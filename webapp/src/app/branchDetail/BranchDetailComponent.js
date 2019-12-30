import React, { Component } from 'react';
import {
    Card,
    CardBody,
    FormGroup,
    Col,
    Container,
    Input,
    Label,
    Button,
    Table
} from 'reactstrap'
import ReactTable from 'react-table'

class BranchDetailComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            branch: {}
        }
    }

    componentDidMount() {
        if (this.props.curUser.roleName === 'BRANCHMANAGER')
            this.props.getBranch(this.props.curUser.branchId);
        else
            this.props.getBranch(this.props.match.params.id);
        setTimeout(() => this.setState({ branch: this.props.branch }), 1000);
    }

    handleInputChange(e) {
        const branch = this.state.branch;
        branch[e.target.name] = e.target.value;
        this.setState({ branch: branch });
    }

    handleStatusChange(e) {
        let branch = this.state.branch;
        branch.status = branch.status === 0 ? 1 : 0;
        this.setState({ branch: branch })
    }

    handleRuleChange(e, index) {
        const branch = this.state.branch;
        branch.rules[index][e.target.name] = e.target.value;
        this.setState({ branch: branch });
    }

    handleClickNew() {
        const branch = this.state.branch;
        branch.rules.push({});
        this.setState({ branch: branch });
    }

    handleRemoveRule(index) {
        const branch = this.state.branch;
        branch.rules.splice(index, 1);
        this.setState({ branch: branch });
    }

    handleUpdateBranch() {
        this.props.updateBranch(this.state.branch);
    }

    render() {
        let dataInput = null;
        if (this.state.branch.rules !== undefined) {
            dataInput = this.state.branch.rules.map((rule, index) => (
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
        }
        return (
            <div className='small_container'>
                <Card>
                    <CardBody>
                        <div className='mid_header'>
                            <h4 className="mb-0"><strong>Thông tin cơ sở</strong></h4>
                            <div className="small text-muted">cơ sở</div>
                            <hr />
                        </div>
                        <Container fluid>
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor="hf-name">Tên cơ sở</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    <Input type='text'
                                        name="name"
                                        value={this.state.branch.name}
                                        onChange={e => this.handleInputChange(e)}
                                    />
                                </Col>
                            </FormGroup>
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor="hf-name">Địa chỉ</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    <Input type='text'
                                        name="address"
                                        value={this.state.branch.address}
                                        onChange={e => this.handleInputChange(e)}
                                    />
                                </Col>
                            </FormGroup>
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor="hf-name">Trạng thái</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    <Input type='checkbox'
                                        name="status"
                                        checked={this.state.branch.status}
                                        onChange={e => this.handleStatusChange(e)}
                                    />
                                </Col>
                            </FormGroup>
                            <hr />
                            <FormGroup row>
                                <Col md="3">
                                    <Label htmlFor="hf-name">Quản lý cơ sở</Label>
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
                                    <Label htmlFor="hf-name">Số điện thoại</Label>
                                </Col>
                                <Col xs="12" md="9">
                                    {this.state.branch.managerPhone}
                                </Col>
                            </FormGroup>
                            <hr />
                            <h5>Các điều khoản quy định</h5>
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
                            {
                                this.props.curRole === '[ROLE_BUSINESSMANAGER]' &&
                                <Button onClick={() => this.handleUpdateBranch()} color='primary' className='float-right'>Lưu</Button>
                            }
                        </Container>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default BranchDetailComponent