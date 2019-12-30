import { connect } from 'react-redux';
import BillComponent from './BillComponent';

import { billOperations } from './duck'

const mapStateToProps = (state) => {
  return {
    listMenuItem: state.bill.listMenuItem,
    billDetails: state.bill.billDetails,
    user : state.home.userInfo
  }
};

const mapDispatchToProps = (dispatch) => {
  const getListMenuItem = (branchId) => dispatch(billOperations.getListMenuItem(branchId));
  const addMenuItemToBill = bill => dispatch(billOperations.addMenuItemToBill(bill));
  const removeMenuItemFromBill = bill => dispatch(billOperations.removeMenuItemFromBill(bill));
  const resetBill = () => dispatch(billOperations.resetBill());
  const saveBill = bill => dispatch(billOperations.saveBill(bill));
  return {
    getListMenuItem,
    addMenuItemToBill,
    removeMenuItemFromBill,
    resetBill,
    saveBill
  }
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(BillComponent);