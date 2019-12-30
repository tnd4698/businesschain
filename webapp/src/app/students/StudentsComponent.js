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

class StudentsComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            modalAdd: false,
            modalUpdate: false,
            filter: {
                branch: 'null',
                tuition: 'null',
                status: '1'
            },
            student: {},
            searchContent: ''
        };
    }

    componentDidMount() {

        this.props.getListBranch();
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListStudent(this.props.curUser.branchId);
        else
            this.props.getListStudent();
    }

    handleFilterChange(event) {
        let filter = this.state.filter;
        filter[event.target.name] = event.target.value;
        this.setState({ filter: filter }, () => this.handleFilter())
    }

    handleFilter() {
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getListStudent(this.props.curUser.branchId, this.state.filter.tuition, this.state.filter.status);
        else
            this.props.getListStudent(this.state.filter.branch, this.state.filter.tuition, this.state.filter.status);
    }

    handleInputChange(event) {
        let student = this.state.student;
        student[event.target.name] = event.target.value;
        this.setState({ student: student })
    }

    handleSaveStudent() {
        this.props.saveStudent(this.state.student);
    }

    handleSearch() {
        if (this.state.searchContent === '')
            this.handleFilter();
        else {
            if (this.props.curUser.roleName === 'BRANCHMANAGER')
                this.props.search(this.state.searchContent,this.props.curUser.branchId, this.state.filter.tuition, this.state.filter.status);
            else
                this.props.search(this.state.searchContent,this.state.filter.branch, this.state.filter.tuition, this.state.filter.status);
        }
        this.forceUpdate();
    }

    handleViewStudent(id) {
        const student = this.props.listStudent.filter(cur=>cur.id===id)[0];
        this.setState({student:student},()=>this.setState({modalUpdate:!this.state.modalUpdate}));
    }

    handleUpdateStudent(){
        this.props.updateStudent(this.state.student);
    }

    handleTuition(student) {
        this.props.toggleTuition(student);
        this.props.history.push('/tuition')
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
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Quản lý học viên</strong></h4>{' '}
                                    {
                                        this.props.curRole==="[ROLE_BRANCHMANAGER]" &&
                                        <Button outline color='info' style={{ display: "inline" }} onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>+</Button>
                                    }                                </Col>
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
                                        name='tuition'
                                        value={this.state.filter.tuition}
                                        onChange={event => this.handleFilterChange(event)}>
                                        <option value="null">Học phí</option>
                                        <option value={1}>Đã thu</option>
                                        <option value={0}>Chưa thu</option>
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
                        <ReactTable
                            data={this.props.listStudent}
                            minRows={5}
                            columns={[
                                {
                                    Header: '#',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{row.index+1}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Mã học viên',
                                    accessor: 'studentID',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Họ tên',
                                    accessor: 'name',
                                    Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                    show: true
                                },
                                {
                                    Header: 'Lớp học',
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
                                    Cell: row => {
                                        if (row.value == 1)
                                            return (
                                                <div style={{ textAlign: 'center' }}>
                                                    <Button color='success' disabled>active</Button>
                                                </div>
                                            )
                                        else
                                            return (
                                                <div style={{ textAlign: 'center' }}>
                                                    <Button color='secondary' disabled>inactive</Button>
                                                </div>
                                            )
                                    },
                                    show: true
                                },
                                {
                                    Header: 'Học phí',
                                    accessor: 'statusTuition',
                                    Cell: row => {
                                        if (row.value === 0 && row.original.status==1)
                                            return (
                                                <div style={{ textAlign: 'center' }}>
                                                    <Button color='warning'
                                                    onClick={()=>this.handleTuition(row.original)}
                                                    >Thu học phí</Button>
                                                </div>
                                            )
                                        else
                                            return (
                                                <div style={{ textAlign: 'center' }}>
                                                    <Button color='secondary' disabled>Thu học phí</Button>
                                                </div>
                                            )
                                    }
                                },
                                {
                                    Header: 'Active',
                                    accessor: 'id',
                                    Cell: row => (
                                        <div style={{ textAlign: 'center' }}>
                                            <Button color='success' onClick={()=>this.handleViewStudent(row.value)}>Xem</Button>
                                        </div>
                                    )
                                }
                            ]}
                        />
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
                                            value={this.state.student.name}
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
                                            value={this.state.student.cardID}
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
                                            value={this.state.student.birthDay}
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
                                            value={this.state.student.gender}
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
                                            value={this.state.student.address}
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
                                            value={this.state.student.phoneNumber}
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
                                            value={this.state.student.email}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalAdd: !this.state.modalAdd })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleSaveStudent()}>Lưu</Button>{' '}
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
                                            value={this.state.student.name}
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
                                            value={this.state.student.cardID}
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
                                            value={this.state.student.birthDay}
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
                                            value={this.state.student.gender}
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
                                            value={this.state.student.address}
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
                                            value={this.state.student.phoneNumber}
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
                                            value={this.state.student.email}
                                            onChange={event => this.handleInputChange(event)}
                                            required />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Lớp</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        {this.state.student.classID}
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modalUpdate: !this.state.modalUpdate })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleUpdateStudent()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default StudentsComponent