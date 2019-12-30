import React, { Component } from 'react';
import {
    Card,
    CardBody,
    Table,
    Input,
    Button,
    Col,
    Label,
    Row
} from 'reactstrap';

class ShipwayComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            fromBranch: '',
            toBranch: '',
            listResource: [],
            listShipway: [],
            shipway: {
                resourceID: '',
                count: 0
            }
        }
    }

    componentDidMount() {
        this.props.getListBranch();
        this.props.getListResource();
    }

    handleShipwayChange(e, index) {
        const listShipway = this.state.listShipway;
        listShipway[index][e.target.name] = e.target.value;
        this.setState({ listShipway: listShipway });
    }

    handleClickNew() {
        const listShipway = this.state.listShipway;
        listShipway.push({});
        this.setState({ listShipway: listShipway });
    }

    handleRemoveShipway(index) {
        const listShipway = this.state.listShipway;
        listShipway.splice(index, 1);
        this.setState({ listShipway: listShipway });
    }

    handleInputChange(e, index) {
        if (e.target.name === 'count') {
            const resource = this.props.listResource.filter(
                cur => cur.resourceID === this.state.listShipway[index].resourceID
                    && cur.branchId==this.state.fromBranch)[0];
            if (e.target.value <= 0 || e.target.value > resource.count) {
                alert(`Số lượng nhập vào không đúng ( 0 -> ${resource.count}`);
                return;
            }
        }
        const listShipway = this.state.listShipway;
        listShipway[index][e.target.name] = e.target.value;
        this.setState({ listShipway: listShipway });
    }

    handleSaveShipway() {
        const listShipway = this.state.listShipway.map(cur => {
            cur.fromBranch = this.state.fromBranch;
            cur.toBranch = this.state.toBranch;
            return cur;
        });

        this.props.saveShipway(listShipway);
    }

    handleFromBranchChange(e) {
        this.setState({ fromBranch: e.target.value }, () => {
            const listResource = this.props.listResource.filter(cur => cur.branchId == this.state.fromBranch);
            this.setState({ listResource: listResource },()=>console.log(this.state.listResource));
        })
    }

    render() {
        const listBranch = this.props.listBranch.map(branch => (
            <option key={branch.id} value={branch.id}>{branch.name}</option>
        ));
        listBranch.unshift(<option key={0} value="" unselectable="true">Cơ sở</option>);

        let dataInput = null;
        dataInput = this.state.listShipway.map((cur, index) => (
            <tr key={index}>
                <td>{index + 1}</td>
                <td>
                    <Input type='select'
                        name='resourceID'
                        value={cur.resourceID}
                        onChange={e => this.handleShipwayChange(e, index)}
                    >
                        <option value='' unselectable="true">Mã hàng hóa</option>
                        {this.state.listResource.map(resource => (
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
                    <Button onClick={() => this.handleRemoveShipway(index)}>Remove</Button>
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
                            <h4 className="mb-0"><strong>Luân chuyển hàng hóa</strong></h4>
                            <div className="small text-muted">{(new Date()).toLocaleString()}</div>
                        </div>
                        <hr />
                        <Row>
                            <Col sm='1'>
                                <Label>From</Label>
                            </Col>
                            <Col sm='4'>
                                <Input type='select'
                                    name="fromBranch"
                                    value={this.state.fromBranch}
                                    onChange={e => this.handleFromBranchChange(e)}
                                >
                                    {listBranch}
                                </Input>
                            </Col>
                            <Col sm='1'>
                                <Label>To</Label>
                            </Col>
                            <Col sm='4'>
                                <Input type='select'
                                    name="toBranch"
                                    value={this.state.toBranch}
                                    onChange={e => this.setState({ toBranch: e.target.value })}
                                >
                                    {listBranch}
                                </Input>
                            </Col>
                        </Row>
                        <hr />
                        <Table>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Code</th>
                                    <th>Số lượng</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {dataInput}
                            </tbody>
                        </Table>
                        <hr />
                        <Button color="primary" className='float-right' onClick={() => this.handleSaveShipway()}>Lưu</Button>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default ShipwayComponent