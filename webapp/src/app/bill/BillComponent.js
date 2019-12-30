import React, { Component } from 'react';
import {
    Card,
    CardBody,
    Button,
    Row,
    Col
} from 'reactstrap'
import ScrollArea from 'react-scrollbar'

class BillComponent extends Component {

    componentDidMount() {
        this.props.getListMenuItem(this.props.user.branchId);
        setTimeout(() => console.log(this.props.listMenuItem), 1000);
    }

    handleAddMenuItemToBill(item) {
        const itemMenu = item.id;
        const count = 1;
        const price = item.price;
        const name = item.name;
        this.props.addMenuItemToBill({ itemMenu, count, price, name });
        this.forceUpdate();
    }

    handleRemoveMenuItemFromBill(billDetail) {
        this.props.removeMenuItemFromBill(billDetail);
        this.forceUpdate();
    }

    render() {
        const formatMoney = num => {
            return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
        }

        const menu = this.props.listMenuItem.map(item => (
            <Col sm={3}>
                <div className='item_menu' onClick={() => this.handleAddMenuItemToBill(item)}>
                    <img src={process.env.PUBLIC_URL +`/img/${item.name.toLowerCase()}.jpg`} className='img_item' alt="Không tìm thấy image" style={{ cursor: "grabbing" }} />
                    <p>{item.name}</p>
                </div>
            </Col>
        ));

        const bill = this.props.billDetails.map(billDetail => (
            <div onClick={() => this.handleRemoveMenuItemFromBill(billDetail)} style={{ cursor: "grabbing" }}>
                <Row>
                    <Col sm={5}>
                        {billDetail.name}
                    </Col>
                    <Col sm={3}>
                        {billDetail.count}
                    </Col>
                    <Col sm={4}>
                        {formatMoney(billDetail.price * billDetail.count)}
                    </Col>
                </Row>
                <hr />
            </div>
        ));

        return (
            <div>
                <Card>
                    <CardBody>
                        <div className='mid_header'>
                            <h4 className="mb-0"><strong>Lập hóa đơn</strong></h4>
                            <div className="small text-muted">{(new Date()).toLocaleString()}</div>
                        </div>
                        <hr />
                        <Row>
                            <Col sm='7'>
                                <Card className='menu'>
                                    <ScrollArea>
                                        <CardBody>
                                            <Row>
                                                {menu}
                                            </Row>
                                        </CardBody>
                                    </ScrollArea>
                                </Card>
                            </Col>
                            <Col sm='5'>
                                <Card className='bill'>
                                    <ScrollArea>
                                        <CardBody>
                                            <Row>
                                                <Col sm={5}>
                                                    Tên món
                                            </Col>
                                                <Col sm={3}>
                                                    Số lượng
                                            </Col>
                                                <Col sm={4}>
                                                    Thành tiền(VND)
                                            </Col>
                                            </Row>
                                            <hr />
                                            {bill}
                                            <Row>
                                                <Col sm={8}>
                                                    Tổng
                                            </Col>
                                                <Col sm={4}>
                                                    {formatMoney(this.props.billDetails.reduce((sum, cur) => sum + cur.price * cur.count, 0))}
                                                </Col>
                                            </Row>
                                            <hr />
                                        </CardBody>
                                    </ScrollArea>
                                </Card>
                                <div style={{ float: "right" }}>
                                    <Button color='success' onClick={() => { this.props.resetBill() }}>Tạo mới</Button>{' '}
                                    <Button color='primary' onClick={() => { this.props.saveBill(this.props.billDetails) }}>Xác nhận</Button>
                                </div>
                            </Col>
                        </Row>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default BillComponent