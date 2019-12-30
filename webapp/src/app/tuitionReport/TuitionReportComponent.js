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
    InputGroup

} from 'reactstrap'
import ReactTable from 'react-table'
import DatePicker from "react-datepicker";


class TuitionReportComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            fromDate: new Date('2019-12-01'),
            toDate: new Date('2020-01-08'),
            branch: 'null',
            searchContent: ''
        }
    }

    componentDidMount() {
        this.props.getListTuitionReport(this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.state.branch);
        this.props.getListBranch();
    }

    handleFilter(){
        this.props.getListTuitionReport(this.state.fromDate.toISOString().split('T')[0], this.state.toDate.toISOString().split('T')[0], this.state.branch);
    }
    
    render() {

        const ExampleCustomInput = ({ value, onClick }) => (
            <Button outline size='sm' color='primary' onClick={onClick}>
                {value}
            </Button>
        );

        const formatMoney = num => {
            return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
        }

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
                                    <h4 className="mb-0" style={{ display: "inline" }}><strong>Thống kê doanh thu giảng dạy</strong></h4>{' '}
                                    <Form inline>
                                        <DatePicker
                                            dateFormat="dd/MM/yyyy"
                                            selected={this.state.fromDate}
                                            onChange={date => this.setState({ fromDate: date },()=>this.handleFilter())}
                                            customInput={<ExampleCustomInput />}
                                        />
                                        <i class="fas fa-angle-double-right"></i>
                                        <InputGroup className='date'>
                                            <DatePicker
                                                dateFormat="dd/MM/yyyy"
                                                selected={this.state.toDate}
                                                onChange={date => this.setState({ toDate: date },()=>this.handleFilter())}
                                                customInput={<ExampleCustomInput />}
                                            />
                                        </InputGroup>
                                    </Form>
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
                                        name='branch'
                                        value={this.state.branch}
                                        onChange={event => this.setState({ [event.target.name]: event.target.value },()=>this.handleFilter())}>
                                        {listBranch}
                                    </Input>
                                </Col>
                            </Row>
                            <hr />
                        </div>
                        <Container fluid>
                            <ReactTable
                                data={this.props.listTuitionReport}
                                minRows={5}
                                columns={[
                                    {
                                        Header: '#',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.index+1}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Cơ sở',
                                        accessor: 'branchName',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{row.value}</div>),
                                        show: true
                                    },
                                    {
                                        Header: 'Doanh thu (VND)',
                                        accessor: 'value',
                                        Cell: row => (<div style={{ textAlign: "center" }}>{formatMoney(row.value)}</div>),
                                        show: true
                                    }
                                ]}
                            />
                        </Container>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default TuitionReportComponent;