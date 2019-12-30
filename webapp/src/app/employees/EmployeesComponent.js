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

class EmployeesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            modalAdd: false,
            modalUpdate: false,
            employeeUpdate: {},
            employee: {
                name: '',
                cardID: '',
                birthDay: '',
                gender: '',
                address: '',
                phoneNumber: '',
                email: '',
                status: 1,
                salary: 0,
                roleId: 0,
                branchId: 0
            },
            filter: {
                branch: 'null',
                role: 'null',
                status: 1
            },
            searchContent: ''
        };
    }

    componentDidMount() {
        this.props.getListBranch();
        this.props.getListRole();
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListEmployee(this.props.curUser.branchId);
        else
            this.props.getListEmployee();
    }

    handleInputChange(event) {
        let employee = this.state.employee;
        employee[event.target.name] = event.target.value;
        this.setState({ employee: employee })
    }

    handleSaveEmployee() {
        this.props.saveEmployee(this.state.employee);
    }

    handleUpdateChange(event) {
        let employee = this.state.employeeUpdate;
        if (event.target.name == 'status') {
            employee.status = employee.status==0?1:0;
        }
        else {
            employee[event.target.name] = event.target.value;
        }
        this.setState({ employeeUpdate: employee })
    }

    handleViewEmployee(id) {
        const employee = this.props.listEmployee.filter(e => e.id === id)[0];
        this.setState({ employeeUpdate: employee },
            () => this.setState({ modalUpdate: !this.state.modalUpdate }))
    }

    handleUpdateEmployee() {
        this.props.updateEmployee(this.state.employeeUpdate.employeeID, this.state.employeeUpdate);
    }

    handleFilterChange(event) {
        let filter = this.state.filter;
        filter[event.target.name] = event.target.value;
        this.setState({ filter: filter }, () => this.handleFilter())
    }

    handleFilter() {
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListEmployee(this.props.curUser.branchId, this.state.filter.role, this.state.filter.status);
        else
            this.props.getListEmployee(this.state.filter.branch, this.state.filter.role, this.state.filter.status);
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

    render() {
        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="null">Chi nhánh</option>);

        const listRole = this.props.listRole.map(role => (
            <option key={role.id} value={role.role}>{role.role}</option>
        ));
        listRole.unshift(<option key={0} value="null">Role</option>);
        return (
            <div>
                <Card>
                    <CardBody>
                        <div className='l_header'>
                            <Row>
                                <Col sm="4">
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Quản lý nhân viên</strong></h4>{' '}
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
                                        name='status'
                                        value={this.state.filter.status}
                                        onChange={event => this.handleFilterChange(event)}>
                                        <option value="null">Status</option>
                                        <option value={1}>active</option>
                                        <option value={0}>inactive</option>
                                    </Input>
                                    <Input type='select' color="primary" className="float-right select_header"
                                        name='role'
                                        value={this.state.filter.role}
                                        onChange={event => this.handleFilterChange(event)}>
                                        {listRole}
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
                                data={this.props.listEmployee}
                                minRows={5}
                                pageSize={10}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Mã nhân viên',
                                        accessor: 'employeeID',
                                        show: true
                                    },
                                    {
                                        Header: 'Họ tên',
                                        accessor: 'name',
                                        show: true
                                    },
                                    {
                                        Header: 'Cơ sở làm việc',
                                        accessor: 'branchName',
                                        show: true
                                    },
                                    {
                                        Header: 'Chức vụ',
                                        accessor: 'roleName',
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
                                        Cell: row => (<div style={{ textAlign: 'center' }}>
                                            <Button color='primary'
                                                onClick={() => this.handleViewEmployee(row.value)}>Xem</Button>
                                        </div>)
                                    }
                                ]}
                            />
                        </Container>
                    </CardBody>
                </Card>


                <Modal isOpen={this.state.modalAdd} toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}
                    className={'modal-info ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}>Thông tin nhân viên</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Họ tên</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='name'
                                            value={this.state.employee.name}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">CMND</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='cardID'
                                            value={this.state.employee.cardID}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày sinh</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='birthDay'
                                            value={this.state.employee.birthDay}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Giới tính</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='gender'
                                            value={this.state.employee.gender}
                                            onChange={event => this.handleInputChange(event)}
                                            required>
                                            <option value='' unselectable='true'>Giới tính</option>
                                            <option value={1}>Nam</option>
                                            <option value={0}>Nữ</option>
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Địa chỉ cư trú</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='address'
                                            value={this.state.employee.address}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Số điện thoại</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='phoneNumber'
                                            value={this.state.employee.phoneNumber}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Email</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='email'
                                            name='email'
                                            value={this.state.employee.email}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Vị trí công việc</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        {
                                            this.props.curRole === '[ROLE_BRANCHMANAGER]' &&
                                            <Input type='select'
                                                name='roleId'
                                                value={this.state.employee.roleId}
                                                onChange={event => this.handleInputChange(event)}
                                                required>
                                                <option value='' unselectable="true">Role</option>
                                                <option value={this.props.listRole.filter(role => role.role === 'STAFF').length > 0
                                                    ? this.props.listRole.filter(role => role.role === 'STAFF')[0].id : -1}
                                                >Nhân viên phục vụ</option>
                                                <option value={this.props.listRole.filter(role => role.role === 'TEACHER').length > 0
                                                    ? this.props.listRole.filter(role => role.role === 'TEACHER')[0].id : -1}
                                                >Giảng viên</option>
                                            </Input>
                                        }
                                        {
                                            this.props.curRole === '[ROLE_BUSINESSMANAGER]' &&
                                            <Input type='select'
                                                name='roleId'
                                                value={this.state.employee.roleId}
                                                onChange={event => this.handleInputChange(event)}
                                                required>
                                                <option value='' unselectable="true">Role</option>
                                                {
                                                    this.props.listRole.map(role => (
                                                        <option key={role.id} value={role.id}>{role.role}</option>
                                                    ))
                                                }
                                            </Input>
                                        }
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-branch">Chi nhánh</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='branchId'
                                            value={this.state.employee.branchId}
                                            onChange={event => this.handleInputChange(event)}
                                            required>
                                            <option value='' unselectable='true'>Chi nhánh</option>
                                            {
                                                this.props.curRole === '[ROLE_BRANCHMANAGER]' ?
                                                    <option value={this.props.curUser.branchId}>
                                                        {this.props.curUser.branchName}
                                                    </option>
                                                    :
                                                    this.props.listBranch.map(branch => (
                                                        <option key={branch.id}
                                                            value={branch.id}>
                                                            {branch.name}
                                                        </option>
                                                    ))
                                            }
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Lương cơ bản (VND)</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='number'
                                            name='salary'
                                            value={this.state.employee.salary}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>

                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleSaveEmployee()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>

                <Modal isOpen={this.state.modalUpdate} toggle={() => this.setState({ modalUpdate: !this.state.modalUpdate })}
                    className={'modal-info ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>Thông tin nhân viên</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Họ tên</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='name'
                                            value={this.state.employeeUpdate.name}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">CMND</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='cardID'
                                            value={this.state.employeeUpdate.cardID}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày sinh</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='birthDay'
                                            value={this.state.employeeUpdate.birthDay}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Giới tính</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='gender'
                                            value={this.state.employeeUpdate.gender}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required>
                                            <option value='' unselectable='true'>Giới tính</option>
                                            <option value={1}>Nam</option>
                                            <option value={0}>Nữ</option>
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Địa chỉ cư trú</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='address'
                                            value={this.state.employeeUpdate.address}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Số điện thoại</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='phoneNumber'
                                            value={this.state.employeeUpdate.phoneNumber}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Email</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='email'
                                            name='email'
                                            value={this.state.employeeUpdate.email}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Vị trí công việc</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        {
                                            this.props.curRole === '[ROLE_BRANCHMANAGER]' &&
                                            <Input type='select'
                                                name='roleId'
                                                value={this.state.employeeUpdate.roleId}
                                                onChange={event => this.handleUpdateChange(event)}
                                                required>
                                                <option value='' unselectable="true">Role</option>
                                                <option value={this.props.listRole.filter(role => role.role === 'STAFF').length > 0
                                                    ? this.props.listRole.filter(role => role.role === 'STAFF')[0].id : -1}
                                                >Nhân viên phục vụ</option>
                                                <option value={this.props.listRole.filter(role => role.role === 'TEACHER').length > 0
                                                    ? this.props.listRole.filter(role => role.role === 'TEACHER')[0].id : -1}
                                                >Giảng viên</option>
                                            </Input>
                                        }
                                        {
                                            this.props.curRole === '[ROLE_BUSINESSMANAGER]' &&
                                            <Input type='select'
                                                name='roleId'
                                                value={this.state.employeeUpdate.roleId}
                                                onChange={event => this.handleUpdateChange(event)}
                                                required>
                                                <option value='' unselectable="true">Role</option>
                                                {
                                                    this.props.listRole.map(role => (
                                                        <option key={role.id} value={role.id}>{role.role}</option>
                                                    ))
                                                }
                                            </Input>
                                        }
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-branch">Chi nhánh</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='branchId'
                                            value={this.state.employeeUpdate.branchId}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required>
                                            <option value='' unselectable='true'>Chi nhánh</option>
                                            {
                                                this.props.curRole === '[ROLE_BRANCHMANAGER]' ?
                                                    <option value={this.props.curUser.branchId}>
                                                        {this.props.curUser.branchName}
                                                    </option>
                                                    :
                                                    this.props.listBranch.map(branch => (
                                                        <option key={branch.id}
                                                            value={branch.id}>
                                                            {branch.name}
                                                        </option>
                                                    ))
                                            }
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Lương cơ bản (VND)</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='number'
                                            name='salary'
                                            value={this.state.employeeUpdate.salary}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                    <FormGroup row>

                                    </FormGroup>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Trạng thái hoạt động</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='checkbox'
                                            name='status'
                                            checked={this.state.employeeUpdate.status}
                                            onChange={event => this.handleUpdateChange(event)}
                                            required />
                                    </Col>
                                    <FormGroup row>

                                    </FormGroup>
                                </FormGroup>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleUpdateEmployee()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default EmployeesComponent