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
import Select from "react-select";


class ClassesComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            modalAdd: false,
            modalUpdate: false,
            filter: {
                branch: 'null',
                status: 1
            },
            searchContent: '',
            class: {},
            options: [],
        };
    }

    componentDidMount() {
        this.props.getListBranch();
        this.props.getListShift();
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListClass(this.props.curUser.branchId);
        else
            this.props.getListClass();

        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListStudent(this.props.curUser.branchId, 'null', '0');
        else
            this.props.getListStudent('null', 'null', '0');

        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListEmployee(this.props.curUser.branchId);
        else
            this.props.getListEmployee();

    }

    handleFilterChange(event) {
        let filter = this.state.filter;
        filter[event.target.name] = event.target.value;
        this.setState({ filter: filter }, () => this.handleFilter())
    }

    handleFilter() {
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListClass(this.props.curUser.branchId, this.state.filter.status);
        else
            this.props.getListClass(this.state.filter.branch, this.state.filter.status);
    }

    handleSearch() {
        if (this.state.searchContent === '')
            this.handleFilter();
        else {
            if (this.props.curUser.roleName === 'BRANCHMANAGER')
                this.props.search(this.state.searchContent, this.props.curUser.branchId, this.state.filter.status);
            else
                this.props.search(this.state.searchContent, this.state.filter.branch, this.state.filter.status);
        }
        this.forceUpdate();
    }

    handleChangeListStudent(value) {
        const classs = this.state.class;
        classs.students = value;
        this.setState({ class: classs });
    }

    handleChangeListSchedule(value) {
        const classs = this.state.class;
        classs.shifts = value;
        this.setState({ class: classs });
    }

    handleInputChange(event) {
        let classs = this.state.class;
        classs[event.target.name] = event.target.value;
        this.setState({ class: classs })
    }

    handleChangeStatus(e) {
        let classs = this.state.class;
        classs.status = classs.status === 0 ? 1 : 0;
        this.setState({ class: classs }, () => console.log(this.state.class))
    }

    handleSaveClass() {
        const listStudent = this.props.listStudent.filter(student => {
            let rs = false;
            for (let i = 0; i < this.state.class.students.length; i++) {
                if (this.state.class.students[i].value === student.id) {
                    rs = true;
                    break;
                }
            }
            return rs;
        })
        const listShift = this.props.listShift.filter(shift => {
            let rs = false;
            for (let i = 0; i < this.state.class.shifts.length; i++) {
                if (this.state.class.shifts[i].value === shift.id) {
                    rs = true;
                    break;
                }
            }
            return rs;
        })

        const classs = this.state.class;
        classs.students = listStudent;
        classs.shifts = listShift;
        classs.branchId = this.props.curUser.branchId;
        classs.status = 1;
        this.setState({ class: classs }, () => {
            this.props.saveClass(this.state.class);
        })

    }

    handleUpdateClass() {
        const listStudent = this.state.class.students.map(cur=>{
            return {
                id: cur.value
            }
        })
        const listShift = this.props.listShift.filter(shift => {
            let rs = false;
            for (let i = 0; i < this.state.class.shifts.length; i++) {
                if (this.state.class.shifts[i].value === shift.id) {
                    rs = true;
                    break;
                }
            }
            return rs;
        })

        const classs = this.state.class;
        classs.students = listStudent;
        classs.shifts = listShift;
        classs.branchId = this.props.curUser.branchId;
        this.setState({ class: classs }, () => {
            this.props.updateClass(this.state.class);
        })

    }

    handleViewClass(id) {
        const classs = this.props.listClass.filter(cur => cur.id === id)[0];
        classs.students = classs.students.map((student => {
            return {
                value: student.id,
                label: student.name
            }
        }))
        classs.shifts = classs.shifts.map(shift => {
            return {
                value: shift.id,
                label: shift.date + ' : ' + shift.time
            }
        })

        this.setState({ class: classs }, () => this.setState({ modalUpdate: !this.state.modalUpdate }))
    }


    render() {
        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="null">Chi nhánh</option>);

        const studentOptions = this.props.listStudent.map(student => {
            return {
                value: student.id,
                label: student.name
            }
        })

        const shiftOptions = this.props.listShift.map(shift => {
            return {
                value: shift.id,
                label: shift.date + ' : ' + shift.time
            }
        })

        const listTeacher = this.props.listEmployee.filter(employee => employee.roleName === 'TEACHER');

        return (
            <div className='EmployeesComponent'>
                <Card>
                    <CardBody>
                        <div className='l_header'>
                            <Row>
                                <Col sm="4">
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Quản lý lớp học</strong></h4>{' '}
                                    {
                                        this.props.curRole === '[ROLE_BRANCHMANAGER]' &&
                                        <Button outline color='info' style={{ display: "inline" }} onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>+</Button>
                                    }
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
                                data={this.props.listClass}
                                minRows={5}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index + 1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Mã lớp học',
                                        accessor: 'classID',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Cơ sở',
                                        accessor: 'branchName',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Status',
                                        accessor: 'status',
                                        Cell: row => (<div style={{ textAlign: "center" }}>
                                            {
                                                row.value===1 && <Button color='success'>Active</Button>
                                            }
                                            {
                                                row.value===0 && <Button color='secondary'>inactive</Button>
                                            }
                                            </div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Active',
                                        accessor: 'id',
                                        Cell: row => (<div style={{ textAlign: 'center' }}><Button color='primary' onClick={() => this.handleViewClass(row.value)}>Xem</Button></div>)
                                    }
                                ]}
                            />
                        </Container>
                    </CardBody>
                </Card>

                <Modal isOpen={this.state.modalAdd} toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}
                    className={'modal-info modal-lg ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalAdd: !this.state.modalAdd })}>Class</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <h5>Thông tin lớp học</h5>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Lịch học</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Select
                                            name="listSchedule"
                                            value={this.state.class.shifts}
                                            options={shiftOptions}
                                            onChange={listSchedule => this.handleChangeListSchedule(listSchedule)}
                                            isMulti
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày bắt đầu</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='fromDate'
                                            value={this.state.class.fromDate}
                                            onChange={e => this.handleInputChange(e)}
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày kết thúc</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='toDate'
                                            value={this.state.class.toDate}
                                            onChange={e => this.handleInputChange(e)}
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Giảng viên</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='teacherId'
                                            value={this.state.class.teacherId}
                                            onChange={e => this.handleInputChange(e)}>
                                            <option key={0} value='null' unselectable="true">Giảng viên</option>
                                            {
                                                listTeacher.map(teacher => (
                                                    <option key={teacher.id} value={teacher.id}>{teacher.employeeID}  :  {teacher.name}</option>
                                                ))
                                            }
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <hr />
                                <h5>Danh sách học viên</h5>
                                <Select
                                    name="listStudent"
                                    value={this.state.class.students}
                                    options={studentOptions}
                                    onChange={listStudent => this.handleChangeListStudent(listStudent)}
                                    isMulti
                                />
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleSaveClass()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>

                <Modal isOpen={this.state.modalUpdate} toggle={() => this.setState({ modalUpdate: !this.state.modalUpdate })}
                    className={'modal-info modal-lg ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>Class</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <h5>Thông tin lớp học</h5>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Trạng thái hoạt động</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='checkbox'
                                            name='status'
                                            checked={this.state.class.status}
                                            onChange={e => this.handleChangeStatus(e)}
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Lịch học</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Select
                                            name="listSchedule"
                                            value={this.state.class.shifts}
                                            options={shiftOptions}
                                            onChange={listSchedule => this.handleChangeListSchedule(listSchedule)}
                                            isMulti
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày bắt đầu</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='fromDate'
                                            value={this.state.class.fromDate}
                                            onChange={e => this.handleInputChange(e)}
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Ngày kết thúc</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='date'
                                            name='toDate'
                                            value={this.state.class.toDate}
                                            onChange={e => this.handleInputChange(e)}
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Giảng viên</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='teacherId'
                                            value={this.state.class.teacherId}
                                            onChange={e => this.handleInputChange(e)}>
                                            <option key={0} value='null' unselectable="true">Giảng viên</option>
                                            {
                                                listTeacher.map(teacher => (
                                                    <option key={teacher.id} value={teacher.id}>{teacher.employeeID}  :  {teacher.name}</option>
                                                ))
                                            }
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <hr />
                                <h5>Danh sách học viên</h5>
                                <Select
                                    name="listStudent"
                                    value={this.state.class.students}
                                    options={studentOptions}
                                    onChange={listStudent => this.handleChangeListStudent(listStudent)}
                                    isMulti
                                />
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleUpdateClass()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default ClassesComponent