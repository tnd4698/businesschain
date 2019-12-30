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
    ModalFooter,
    Table
} from 'reactstrap'
import ReactTable from 'react-table'

class BranchesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            modalAdd: false,
            modalUpdate: false,
            status: 'null',
            searchContent: '',
            branch: {},
            rules: []
        };
    }

    componentDidMount() {
        this.props.getListBranch();
        this.props.getListEmployee();
    }

    handleFilter(e) {
        this.setState({ status: e.target.value }, () => {
            this.props.getListBranch(this.state.status)
        })
    }

    handleSearch() {
        if (this.state.searchContent === '')
            this.handleFilter();
        else
            this.props.search(this.state.searchContent, this.state.filter.status);

        this.forceUpdate();
    }

    handleInputChange(event) {
        let branch = this.state.branch;
        branch[event.target.name] = event.target.value;
        this.setState({ branch: branch })
    }

    handleSaveBranch() {
        const branch = this.state.branch;
        branch.rules = this.state.rules;
        branch.status = 1;
        this.setState({ branch: branch }, () => {
            this.props.saveBranch(this.state.branch);
        })
    }

    handleRuleChange(e, index) {
        const rules = this.state.rules;
        rules[index][e.target.name] = e.target.value;
        this.setState({ rules: rules });
    }

    handleClickNew() {
        const rules = this.state.rules;
        rules.push({});
        this.setState({ rules: rules });
    }

    handleRemoveRule(index) {
        const rules = this.state.rules;
        rules.splice(index,1);
        this.setState({ rules: rules });
    }

    handleViewBranch(id) {
        this.props.history.push('/branchs/' + id);
    }

    render() {
        const dataInput = this.state.rules.map((rule, index) => (
            <tr key={index}>
                <td>{index + 1}</td>
                <td>
                    <Input type='text'
                        name='name'
                        value={rule.name}
                        onChange={e => this.handleRuleChange(e, index)}
                    />
                </td>
                <td>
                    <Input type='text'
                        name='value'
                        value={rule.value}
                        onChange={e => this.handleRuleChange(e, index)}
                    />
                </td>
                <td>
                    <Input type='select'
                        name='type'
                        value={rule.type}
                        onChange={e => this.handleRuleChange(e, index)}
                    >
                        <option value='' unselectable="true">Type</option>
                        <option value={0}>Menu</option>
                        <option value={1}>Hợp đồng</option>
                    </Input>
                </td>
                <td>
                    <Button onClick={() => this.handleRemoveRule(index)}>Remove</Button>
                </td>
            </tr>
        ));

        dataInput.push((
            <tr>
                <td>{dataInput.length + 1}</td>
                <td>
                    <Input type='text' onClick={() => this.handleClickNew()} />
                </td>
                <td>
                    <Input type='text' onClick={() => this.handleClickNew()} />
                </td>
                <td>
                    <Input type='text' onClick={() => this.handleClickNew()} />
                </td>
            </tr>
        ))

        return (
            <div className='EmployeesComponent'>
                <Card>
                    <CardBody>
                        <div className='l_header'>
                            <Row>
                                <Col sm="4">
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Quản lý cơ sở</strong></h4>{' '}
                                    <Button outline color='info' style={{ display: "inline" }} onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>+</Button>
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
                                        value={this.state.status}
                                        onChange={(e) => this.handleFilter(e)}>
                                        <option value="null">Status</option>
                                        <option value={1}>active</option>
                                        <option value={0}>inactive</option>
                                    </Input>
                                </Col>
                            </Row>
                            <hr />
                        </div>
                        <Container fluid>
                            <ReactTable
                                data={this.props.listBranch}
                                minRows={5}
                                pageSize={5}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Tên cơ sở',
                                        accessor: 'name',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Địa chỉ',
                                        accessor: 'address',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Quản lý',
                                        accessor: 'managerName',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Liên hệ',
                                        accessor: 'managerPhone',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Status',
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
                                        accessor: 'id',
                                        Cell: row => (<div style={{ textAlign: 'center' }}><Button color='primary' onClick={() => this.handleViewBranch(row.value)}>Xem</Button></div>)
                                    }
                                ]}
                            />
                        </Container>
                    </CardBody>
                </Card>


                <Modal isOpen={this.state.modalAdd} toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}
                    className={'modal-info modal-lg ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}><strong>Thêm cơ sở</strong></ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <h5>Thông tin cơ sở</h5>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Tên cơ sở</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='name'
                                            value={this.state.branch.name}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Địa chỉ</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='address'
                                            value={this.state.branch.address}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Nhân viên quản lý</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='managerId'
                                            value={this.state.branch.managerId}
                                            onChange={event => this.handleInputChange(event)}
                                            required >
                                            <option value="" unselectable="true">Quản lý</option>
                                            {
                                                this.props.listEmployee.filter(employee => employee.roleName === 'BRANCHMANAGER')
                                                    .map(manager => (
                                                        <option value={manager.id}>{manager.name}</option>
                                                    ))
                                            }
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày khai trương</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='openDate'
                                            value={this.state.branch.openDate}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>

                                <hr />
                                <h5>Quy định</h5>
                                <Table>
                                    <thead>
                                        <tr style={{ textAlign: "center" }}>
                                            <th>#</th>
                                            <th>name</th>
                                            <th>value</th>
                                            <th>type</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {dataInput}
                                    </tbody>
                                </Table>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modal: !this.state.modal })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleSaveBranch()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>

            </div>
        );
    }
}

export default BranchesComponent