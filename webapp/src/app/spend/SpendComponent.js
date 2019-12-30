import React, { Component } from 'react';
import {
    Card,
    CardBody,
    Input,
    Button,
    Label,
    Form,
    FormGroup,
    Col
} from 'reactstrap';

class SpendComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            spend: {}
        }
    }

    componentDidMount(){
        this.props.getListBranch('null');
    }

    handleInputChange(e) {
        const spend = this.state.spend;
        spend[e.target.name] = e.target.value;
        this.setState({ spend: spend });
    }

    handleSaveSpend() {
        this.props.saveSpend(this.state.spend);
    }

    render() {

        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="" unselectable="true">Cơ sở</option>);

        return (
            <div className='small_container'>
                <Card>
                    <CardBody>
                        <div className='mid_header'>
                            <h4 className="mb-0"><strong>Lập phiếu chi</strong></h4>
                            <div className="small text-muted">{(new Date()).toLocaleString()}</div>
                        </div>
                        <hr />
                        <Form className="form-horizontal">
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor="hf-name">Nội dung</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    <Input type='textarea' id='spend-content'
                                        name='content'
                                        value={this.state.spend.content}
                                        onChange={e => this.handleInputChange(e)}
                                    />
                                </Col>
                            </FormGroup>
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor='spend-total'>Số tiền(VND)</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    <Input type='number' id='spend-total'
                                        name='totalMoney'
                                        value={this.state.spend.totalMoney}
                                        onChange={e => this.handleInputChange(e)}
                                    />
                                </Col>
                            </FormGroup>
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor='spend-total'>Cơ sở</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    <Input type='select' id='spend-total'
                                        name='branch'
                                        value={this.state.spend.branch}
                                        onChange={e => this.handleInputChange(e)}
                                    >
                                        {listBranch}
                                    </Input>
                                </Col>
                            </FormGroup>
                        </Form>
                        <hr />
                        <Button color="primary" className='float-right' onClick={()=>this.handleSaveSpend()}>Lưu</Button>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default SpendComponent