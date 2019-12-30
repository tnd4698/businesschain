import React, { Component } from 'react';
import {
    Card,
    CardBody,
    Button,
    Label,
    Form,
    FormGroup,
    Col,
    Row,
    Container,
    Input,
    InputGroup,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter
} from 'reactstrap'
import ReactTable from 'react-table'

class ResourcesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            modal: false,
            filter: {
                branch: 'null',
                type: 'null',
                status: '1'
            },
            searchContent: '',
            resource: {}
        };

    }

    componentDidMount() {
        this.props.getListBranch();
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListResource(this.props.curUser.branchId);
        else
            this.props.getListResource();
    }

    handleFilterChange(event) {
        let filter = this.state.filter;
        filter[event.target.name] = event.target.value;
        this.setState({ filter: filter }, () => this.handleFilter())
    }

    handleFilter() {
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListResource(this.props.curUser.branchId, this.state.filter.type, this.state.filter.status);
        else
            this.props.getListResource(this.state.filter.branch, this.state.filter.type, this.state.filter.status);
    }

    handleSearch() {
        if (this.state.searchContent === '')
            this.handleFilter();
        else {
            if (this.props.curUser.roleName === 'BRANCHMANAGER')
                this.props.search(this.state.searchContent, this.props.curUser.branchId, this.state.filter.role, this.state.filter.status);
            else
                this.props.search(this.state.searchContent, this.state.filter.branch, this.state.filter.role, this.state.filter.status);
        }
        this.forceUpdate();
    }

    handleViewResource(resourceID) {
        const resource = this.props.listResource.filter(cur => cur.resourceID === resourceID)[0];
        this.setState({ resource: resource }, () => this.setState({ modal: !this.state.modal }))
    }

    handleChange(e) {
        let resource = this.state.resource;
        resource[e.target.name] = e.target.value;
        this.setState({ resource: resource })
    }

    handleChangeStatus(e) {
        let resource = this.state.resource;
        resource.status = resource.status === 0 ? 1 : 0;
        this.setState({ resource: resource })
    }

    handleUpdateResource() {
        this.props.updateResource(this.state.resource);
    }

    render() {

        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="null">Chi nhánh</option>);
        return (
            <div className='EmployeesComponent'>
                <Card>
                    <CardBody>
                        <div className='l_header'>
                            <Row>
                                <Col sm="4">
                                    <h4 className="mb-0"><strong>Quản lý tài sản</strong></h4>
                                </Col>
                                <Col sm="8" className="d-none d-sm-inline-block">
                                    <InputGroup className='float-right search'>
                                        <Input type="text" id="input1-group2" placeholder="Search"
                                            name='searchContent'
                                            value={this.state.searchContent}
                                            onChange={event => this.setState({ [event.target.name]: event.target.value })}
                                        />
                                        <div className="input-group-append">
                                            <Button onClick={() => this.handleSearch()} type="button" color="primary"><i className="fa fa-search"></i></Button>
                                        </div>
                                    </InputGroup>
                                    <Input type='select' color="primary" className="float-right select_header"
                                        name='status'
                                        value={this.state.filter.status}
                                        onChange={event => this.handleFilterChange(event)}>
                                        <option value="null">Status</option>{' '}
                                        <option value={1}>active</option>
                                        <option value={0}>inactive</option>
                                    </Input>
                                    <Input type='select' color="primary" className="float-right select_header"
                                        name='type'
                                        value={this.state.filter.type}
                                        onChange={event => this.handleFilterChange(event)}>
                                        <option value="null">Loại</option>
                                        <option value='0'>Hàng hóa</option>
                                        <option value='1'>Cơ sở vật chất</option>
                                    </Input>
                                    {
                                        this.props.curRole === '[ROLE_BUSINESSMANAGER]' &&
                                        <Input type='select' color="primary" className="float-right select_header"
                                            name='branch'
                                            value={this.state.filter.branch}
                                            onChange={event => this.handleFilterChange(event)}>
                                            {listBranch}
                                        </Input>
                                    }
                                </Col>
                            </Row>
                            <hr />
                        </div>
                        <Container fluid>
                            <ReactTable
                                data={this.props.listResource}
                                minRows={5}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Mã',
                                        accessor: 'resourceID',
                                        show: true
                                    },
                                    {
                                        Header: 'Tên',
                                        accessor: 'name',
                                        show: true
                                    },
                                    {
                                        Header: 'Loại',
                                        accessor: 'type',
                                        Cell: row => {
                                            if (row.value === 1)
                                                return (
                                                    <div style={{ textAlign: 'center' }}>
                                                        Cơ sở vật chất
                                                    </div>
                                                )
                                            else
                                                return (
                                                    <div style={{ textAlign: 'center' }}>
                                                        Hàng hóa
                                                    </div>
                                                )
                                        },
                                        show: true
                                    },
                                    {
                                        Header: 'Cơ sở',
                                        accessor: 'branchName',
                                        show: true
                                    },
                                    {
                                        Header: 'Số lượng',
                                        accessor: 'count',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Trạng thái',
                                        accessor: 'status',
                                        Cell: row => {
                                            if (row.value === 1)
                                                return (
                                                    <div style={{ textAlign: 'center' }}>
                                                        <Button color='success'>active</Button>
                                                    </div>
                                                )
                                            else
                                                return (
                                                    <div style={{ textAlign: 'center' }}>
                                                        <Button color='secondary'>inactive</Button>
                                                    </div>
                                                )
                                        },
                                        show: true
                                    },
                                    {
                                        Header: 'Active',
                                        accessor: 'resourceID',
                                        Cell: row => (<div style={{ textAlign: 'center' }}>
                                            <Button color='primary'
                                                onClick={() => this.handleViewResource(row.value)}>Xem</Button>
                                        </div>)
                                    }
                                ]}
                            />
                        </Container>
                    </CardBody>
                </Card>
                <Modal isOpen={this.state.modal} toggle={() => this.setState({ modal: !this.state.modal })}
                    className={'modal-info ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modal: !this.state.modal })}>$ Mã tài sản</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Tên</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        {this.state.resource.name}
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Cơ sở</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        {this.state.resource.branchName}
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Số lượng (Gói)</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='number'
                                            name='count'
                                            value={this.state.resource.count}
                                            onChange={e => this.handleChange(e)} />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Trạng thái</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='checkbox'
                                            name='status'
                                            checked={this.state.resource.status}
                                            onChange={e => this.handleChangeStatus(e)} />
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modal: !this.state.modal })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleUpdateResource()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default ResourcesComponent