import React, { Component } from 'react';
import {
    Card,
    CardBody,
    CardFooter,
    Button,
    Label,
    Form,
    FormGroup,
    Col,
    Container,
    Input
} from 'reactstrap'

class TuitionComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            totalMoney: 0,
            student: {
                id: 0
            }
        }
    }

    componentDidMount() {
        this.props.getListStudent(this.props.curUser.branchId, 0, 1);
        setTimeout(() => this.setState({ student: this.props.student }), () => console.log(this.props.student), 1000);
    }

    chooseStudent(e) {
        let student;
        if (e.target.value !== "")
            student = this.props.listStudent.filter(cur => cur.id == e.target.value)[0];
        else
            student = {
                id: 0,
                name: '',
                classID: ''
            }

        this.props.chooseStudent(student);
        this.setState({ student: student });
    }

    saveTuition() {
        const studentId = this.props.student.id;
        const totalMoney = this.state.totalMoney;
        const classId = this.props.student.classId;
        const classID = this.state.student.classID;
        const name = this.state.student.name;
        const studentID = this.props.student.studentID;
        this.props.saveTuition({ studentId, totalMoney, classId,classID,name,studentID});
        this.setState({
            student: {
                id: 0,
                name: '',
                classID: ''
            }
        })
    }

    render() {
        const listStudent = this.props.listStudent.map(student => (
            <option key={student.id} value={student.id}>
                {student.studentID} : {student.name}
            </option>
        ));
        listStudent.unshift(<option key={0} value="" unselectable="true">Chọn học viên</option>);

        return (
            <div className='small_container'>
                <Card>
                    <CardBody>
                        <div className='mid_header'>
                            <h4 className="mb-0"><strong>Lập phiếu thu học phí</strong></h4>
                            <div className="small text-muted">{(new Date()).toLocaleString()}</div>
                            <hr />
                        </div>
                        <Container fluid className="main_tuition">
                            <Form className="form-horizontal">
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-id">Mã học viên</Label>
                                    </Col>
                                    <Col xs="12" md="8">
                                        <Input type='select'
                                            name='student'
                                            value={this.state.student.id}
                                            onChange={e => this.chooseStudent(e)}
                                        >
                                            {listStudent}
                                        </Input>
                                    </Col>
                                    <Col xs="12" md="1">
                                        <Button color='primary' onClick={() => { this.props.history.push('/students') }}><i className="fas fa-list"></i></Button>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Tên học viên</Label>
                                    </Col>
                                    <Col xs="12" md="8">
                                        {this.state.student.name}
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-class">Lớp học</Label>
                                    </Col>
                                    <Col xs="12" md="8">
                                        {this.state.student.classID}
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-tuition">Số tiền thu(VND)</Label>
                                    </Col>
                                    <Col xs="12" md="8">
                                        <Input type='number'
                                            name='totalMoney'
                                            value={this.state.totalMoney}
                                            onChange={e => this.setState({ totalMoney: e.target.value })}
                                        />
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Container>
                    </CardBody>
                    <CardFooter>
                        <Button className='float-right' color='primary'
                            onClick={() => this.saveTuition()}>
                            Xác nhận</Button>
                    </CardFooter>
                </Card>
                {this.props.toggleText}
            </div>
        );
    }
}

export default TuitionComponent;