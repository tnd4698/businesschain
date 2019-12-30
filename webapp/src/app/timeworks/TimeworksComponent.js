import React, { Component } from 'react';
import {
    Card,
    CardBody,
    Button,
    Form,
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
import DatePicker from "react-datepicker";


class TimeworksComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            modalAdd: false,
            modalUpdate: false,
            branch: 'null',
            fromDate: new Date('2019-12-01'),
            toDate: new Date(),
            timeworks: [
                {
                    date: ''
                }
            ],
            date: (new Date()).toISOString().split('T')[0],
            searchContent: ''
        }
    }

    componentDidMount() {
        this.props.getListBranch();
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListTimeworkList(this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.props.curUser.branchId);
        else
            this.props.getListTimeworkList(this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0]);
    }

    handleAddToggle() {
        this.props.getListNewTimework(this.state.date, this.props.curUser.branchId);
        setTimeout(() => this.setState({ timeworks: this.props.listNewTimework },
            () => this.setState({ modalAdd: !this.state.modalAdd })), 1000)

    }

    handleChangeStatus(index, event) {
        const timeworks = this.state.timeworks;
        timeworks[index].status = timeworks[index].status === 0 ? 1 : 0;
        this.setState({ timeworks: timeworks });
    }

    handleSaveTimeworks() {
        this.props.saveTimeworks(this.state.timeworks);
    }

    handleUpdateToggle(date, branchId) {
        this.props.getListTimework(date, branchId);
        setTimeout(() => this.setState({ timeworks: this.props.listTimework },
            () => this.setState({ modalUpdate: !this.state.modalUpdate })), 1000)
    }

    handleUpdateTimeworks() {
        this.props.updateTimeworks(this.state.timeworks);
    }

    handleFilter() {
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListTimeworkList(this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.props.curUser.branchId);
        else
            this.props.getListTimeworkList(this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.state.branch);

    }

    handleSearch() {
        if (this.state.searchContent === '')
            this.handleFilter();
        else {
            if (this.props.curUser.roleName === 'BRANCHMANAGER')
                this.props.search(this.state.searchContent, this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.props.curUser.branchId);
            else
                this.props.search(this.state.searchContent, this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.state.branch);
        }
        this.forceUpdate();
    }

    render() {
        const ExampleCustomInput = ({ value, onClick }) => (
            <Button outline size='sm' color='primary' onClick={onClick}>
                {value}
            </Button>
        );

        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="null">Chi nhánh</option>);

        return (
            <div>
                <Card>
                    <CardBody>
                        <div className='l_header'>
                            <Row>
                                <Col sm="4">
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Quản lý thời gian làm việc</strong></h4>{' '}
                                    <Button outline color='info' style={{ display: "inline" }} onClick={() => this.handleAddToggle()}>+</Button>
                                    <Form inline>
                                        <DatePicker
                                            dateFormat="dd/MM/yyyy"
                                            name="fromDate"
                                            selected={this.state.fromDate}
                                            onChange={date => this.setState({ fromDate: date }, () => this.handleFilter())}
                                            customInput={<ExampleCustomInput />}
                                        />
                                        <i class="fas fa-angle-double-right    "></i>
                                        <InputGroup className='date'>
                                            <DatePicker
                                                dateFormat="dd/MM/yyyy"
                                                name="toDate"
                                                selected={this.state.toDate}
                                                onChange={date => this.setState({ toDate: date }, () => this.handleFilter())}
                                                customInput={<ExampleCustomInput />}
                                            />
                                        </InputGroup>
                                    </Form>
                                </Col>
                                <Col sm="8" className="d-none d-sm-inline-block">
                                    <InputGroup className='float-right search'>
                                        <Input type="text" id="input1-group2"
                                            name="searchContent"
                                            value={this.state.searchContent}
                                            onChange={e => this.setState({ searchContent: e.target.value })}
                                            placeholder="Search" />
                                        <div className="input-group-append">
                                            <Button color="primary" onClick={() => this.handleSearch()}><i className="fa fa-search"></i></Button>
                                        </div>
                                    </InputGroup>
                                    {
                                        this.props.curRole === '[ROLE_BUSINESSMANAGER]' &&
                                        <Input type='select' color="primary" className="float-right select_header"
                                            name='branch'
                                            value={this.state.branch}
                                            onChange={event => this.setState({ branch: event.target.value }, () => this.handleFilter())}>
                                            {listBranch}
                                        </Input>
                                    }
                                </Col>
                            </Row>
                            <hr />
                        </div>
                        <Container fluid>
                            <ReactTable
                                data={this.props.listTimeworkList}
                                minRows={5}
                                getTrProps={(state, rowInfo) => {
                                    return {
                                        onClick: (e) => this.handleUpdateToggle(rowInfo.original.date, rowInfo.original.branchId)
                                    }
                                }}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Cơ sở',
                                        accessor: 'branchName',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Ngày',
                                        accessor: 'date',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Active',
                                        accessor: 'branchId',
                                        Cell: row => (<div style={{ textAlign: 'center' }}>
                                            <Button color='primary'>Xem</Button>
                                        </div>)
                                    }
                                ]}
                            />
                        </Container>
                    </CardBody>
                </Card>
                <Modal isOpen={this.state.modalAdd} toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}
                    className={'modal-info modal-lg ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}>
                        <h5>Timework</h5>
                        <Input type='date'
                            value={this.state.date}
                        />
                    </ModalHeader>
                    <ModalBody>
                        <Container>
                            <ReactTable
                                data={this.state.timeworks}
                                minRows={0}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Mã nhân viên',
                                        accessor: 'employeeID',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Tên nhân viên',
                                        accessor: 'employeeName',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Active',
                                        accessor: 'status',
                                        Cell: row => (<div style={{ textAlign: 'center' }}>
                                            <Input type='checkbox'
                                                checked={row.value}
                                                onChange={event => this.handleChangeStatus(row.index, event)}
                                            />
                                        </div>)
                                    }
                                ]}
                            />
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>Thoát</Button>
                        <Button color="primary" onClick={() => this.handleSaveTimeworks()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>

                <Modal isOpen={this.state.modalUpdate} toggle={() => this.setState({ modalUpdate: !this.state.modalUpdate })}
                    className={'modal-info modal-lg ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>
                        <h5>Timework</h5>
                        <Input type='date'
                            value={this.state.timeworks[0].date}
                        />
                    </ModalHeader>
                    <ModalBody>
                        <Container>
                            <ReactTable
                                data={this.state.timeworks}
                                minRows={0}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Mã nhân viên',
                                        accessor: 'employeeID',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Tên nhân viên',
                                        accessor: 'employeeName',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Active',
                                        accessor: 'status',
                                        Cell: row => (<div style={{ textAlign: 'center' }}>
                                            <Input type='checkbox'
                                                checked={row.value}
                                                onChange={event => this.handleChangeStatus(row.index, event)}
                                            />
                                        </div>)
                                    }
                                ]}
                            />
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>Thoát</Button>
                        <Button color="primary" onClick={() => this.handleUpdateTimeworks()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default TimeworksComponent