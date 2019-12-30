import React, { Component } from 'react';
import {
    Card,
    CardBody,
    Table,
    Input,
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter,
    Container,
    Form,
    FormGroup,
    Col,
    Label
} from 'reactstrap';

class ImportComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            listImport: [],
            modal: false,
            resource: {
                name: '',
                type: 0
            }
        }
    }

    componentDidMount() {
        this.props.getListResource('null','null','null');
    }

    handleResourceChange(e) {
        const resource = this.state.resource;
        resource[e.target.name] = e.target.value;
        this.setState({ resource: resource });
    }

    handleAddResource() {
        const resource = this.state.resource;
        resource.branchId = this.props.curUser.branchId;
        this.props.saveResource(resource);
        setTimeout(() => {
            this.props.getListResource('null','null','null');
            setTimeout(()=>this.forceUpdate(),1000)
        }, 1000);
    }

    handleImportChange(e, index) {
        if (e.target.value === '-1') {
            this.setState({ modal: !this.state.modal });
            return;
        }
        const listImport = this.state.listImport;
        listImport[index][e.target.name] = e.target.value;
        this.setState({ listImport: listImport });
    }

    handleClickNew() {
        const listImport = this.state.listImport;
        listImport.push({});
        this.setState({ listImport: listImport });
    }

    handleRemoveImport(index) {
        const listImport = this.state.listImport;
        listImport.splice(index, 1);
        this.setState({ listImport: listImport });
    }

    handleInputChange(e, index) {
        const listImport = this.state.listImport;
        listImport[index][e.target.name] = e.target.value;
        this.setState({ listImport: listImport });
    }

    handleSaveImport() {
        const listImport = this.state.listImport.map(cur => {
            cur.totalMoney = cur.count * cur.price;
            return cur;
        });

        this.props.saveImport(listImport);
    }

    render() {
        let dataInput = null;
        dataInput = this.state.listImport.map((cur, index) => (
            <tr key={index}>
                <td>{index + 1}</td>
                <td>
                    <Input type='select'
                        name='resourceID'
                        value={cur.resourceID}
                        onChange={e => this.handleImportChange(e, index)}
                    >
                        <option value='' unselectable="true">Mã hàng hóa</option>
                        <option value='-1'>Tạo mới...</option>
                        {this.props.listResource.map(resource => (
                            <option key={resource.id} value={resource.resourceID}>
                                {resource.name}
                            </option>
                        ))}
                    </Input>
                </td>
                <td>
                    <Input type='number'
                        name='count'
                        value={cur.count}
                        onChange={e => this.handleInputChange(e, index)}
                    />
                </td>
                <td>
                    <Input type='number'
                        name='price'
                        value={cur.price}
                        onChange={e => this.handleInputChange(e, index)}
                    />
                </td>
                <td>
                    {cur.count * cur.price}
                </td>
                <td>
                    <Button onClick={() => this.handleRemoveImport(index)}>Remove</Button>
                </td>
            </tr>
        ));

        dataInput.push((
            <tr>
                <td>{dataInput.length + 1}</td>
                <td>
                    <Input type='text' placeholder="Mã hàng hóa" onClick={() => this.handleClickNew()} />
                </td>
            </tr>
        ))


        return (
            <div className='small_container'>
                <Card>
                    <CardBody>
                        <div className='mid_header'>
                            <h4 className="mb-0"><strong>Lập phiếu nhập</strong></h4>
                            <div className="small text-muted">{(new Date()).toLocaleString()}</div>
                        </div>
                        <hr />
                        <Table responsive>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Code</th>
                                    <th>Số lượng</th>
                                    <th>Đơn giá(VND)</th>
                                    <th>Thành tiền(VND)</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {dataInput}
                            </tbody>
                        </Table>
                        <hr />
                        <Button onClick={() => this.handleSaveImport()} color="primary" className='float-right'>Lưu</Button>
                    </CardBody>
                </Card>
                <Modal isOpen={this.state.modal} toggle={() => this.setState({ modal: !this.state.modal })}
                    className={'modal-info ' + this.props.className}>
                    <ModalHeader toggle={() => this.setState({ modal: !this.state.modal })}>Resource</ModalHeader>
                    <ModalBody>
                        <Container>
                            <Form className="form-horizontal">
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Tên</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='text'
                                            name='name'
                                            value={this.state.resource.name}
                                            onChange={e => this.handleResourceChange(e)} />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Col md="3">
                                        <Label htmlFor="hf-name">Phân loại</Label>
                                    </Col>
                                    <Col xs="12" md="9">
                                        <Input type='select'
                                            name='type'
                                            value={this.state.resource.type}
                                            onChange={e => this.handleResourceChange(e)}>
                                            <option value={0}>Hàng hóa</option>
                                            <option value={1}>Cơ sở vật chất</option>
                                        </Input>
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Container>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={() => this.setState({ modal: !this.state.modal })}>Thoát</Button>{' '}
                        <Button color="primary" onClick={() => this.handleAddResource()}>Lưu</Button>{' '}
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default ImportComponent