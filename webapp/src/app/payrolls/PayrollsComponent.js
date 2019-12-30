import React, { Component } from 'react';
import {
    Card,
    CardBody,
    FormGroup,
    Col,
    Label,
    Input,
    Button,
    Row,
    InputGroup,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter,
    Container,
    Form
} from 'reactstrap';
import ReactTable from 'react-table'

class PayrollsComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modal: false,
            filter: {
                branch: 'null',
                role: 'null',
                month: '2019-12'
            },
            searchContent: '',
            payroll: {}
        }
    }

    componentDidMount() {
        this.props.getListBranch();
        this.props.getListRole();
        this.props.getListPayroll(this.state.filter.month.split('-')[1], this.state.filter.month.split('-')[0]);
    }

    handleFilterChange(event) {
        let filter = this.state.filter;
        filter[event.target.name] = event.target.value;
        this.setState({ filter: filter }, () => this.handleFilter())
    }

    handleFilter() {
        this.props.getListPayroll(this.state.filter.month.split('-')[1], this.state.filter.month.split('-')[0],this.state.filter.branch,this.state.filter.role);
    }

    handleSearch() {
        if (this.state.searchContent === '')
            this.handleFilter();
        else {
                // this.props.search(this.state.searchContent,this.props.curUser.branchId, this.state.filter.role, this.state.filter.status);
        }
        this.forceUpdate();
    }

    toggleEdit(employeeId) {
        const payroll = this.props.listPayroll.filter(cur => cur.employee === employeeId)[0];
        this.setState({ payroll: payroll },()=>this.setState({modal:!this.state.modal}));
    }

    handlePayrollChange(e) {
        const payroll = this.state.payroll;
        payroll[e.target.name] = e.target.value;
        this.setState({ payroll: payroll });
    }

    editPayroll(){
        this.props.editPayroll(this.state.payroll);
        setTimeout(()=>this.setState({listPayroll:this.props.listPayroll},()=>this.setState({modal:!this.state.modal})));
    }

    savePayroll(){
        const listPayroll = this.props.listPayroll.map(payroll => {
            payroll.totalMoney = Math.ceil(payroll.salary * (30 - payroll.absent) / 30 + parseInt(payroll.other));
            return payroll;
        })
        this.props.savePayroll(listPayroll);
    }

    render() {

        const formatMoney = num => {
            return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
        }

        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="null">Chi nhánh</option>);

        const listRole = this.props.listRole.map(role => (
            <option key={role.id} value={role.id}>{role.role}</option>
        ));
        listRole.unshift(<option key={0} value="null">Role</option>);

        return (
            <div>
                <Card>
                    <CardBody>
                        <div className='l_header'>
                            <Row>
                                <Col sm="4">
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Thanh toán lương</strong></h4>{' '}
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
                                        name='role'
                                        value={this.state.filter.role}
                                        onChange={event => this.handleFilterChange(event)}>
                                        {listRole}
                                    </Input>
                                    <Input type='select' color="primary" className="float-right select_header"
                                        name='branch'
                                        value={this.state.filter.branch}
                                        onChange={event => this.handleFilterChange(event)}>
                                        {listBranch}
                                    </Input>
                                </Col>
                            </Row>
                        </div>
                        <hr />
                        <FormGroup row>
                            <Col sm={2}>
                                <Label>Tháng lương</Label>
                            </Col>
                            <Col sm={2.1}>
                                <Input type='month'
                                    name='month'
                                    value={this.state.filter.month}
                                    onChange={e => this.handleFilterChange(e)}
                                />
                            </Col>
                        </FormGroup>
                        <hr />
                        <ReactTable
                            data={this.props.listPayroll}
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
                                    Header: 'Họ tên',
                                    accessor: 'employeeName',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Lương cơ bản',
                                    accessor: 'salary',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{formatMoney(row.value)}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Số ngày nghỉ',
                                    accessor: 'absent',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Các khoản khác',
                                    accessor: 'other',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Tổng',
                                    accessor: 'totalMoney',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{formatMoney(Math.ceil(row.original.salary * (30 - row.original.absent) / 30 + parseInt(row.original.other)))}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Active',
                                    Cell: row => (<div style={{ textAlign: 'center' }}><Button color='success' onClick={() => this.toggleEdit(row.original.employee)}>Edit</Button></div>)
                                }
                            ]}
                            minRows={5}
                        />
                        <hr />
                        <Button color="primary" className='float-right'
                        onClick={()=>this.savePayroll()}>Xác nhận</Button>
                    </CardBody>
                </Card>
                <Modal isOpen={this.state.modal} toggle={() => this.setState({ modal: !this.state.modal })}
                    className={'modal-info ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modal: !this.state.modal })}>Edit</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Khoản khác</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='number'
                                            name='other'
                                            value={this.state.payroll.other}
                                            onChange={e => this.handlePayrollChange(e)}
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Chú thích</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='contentOther'
                                            value={this.state.payroll.contentOther}
                                            onChange={e => this.handlePayrollChange(e)}
                                        />
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modal: !this.state.modal })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.editPayroll()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default PayrollsComponent