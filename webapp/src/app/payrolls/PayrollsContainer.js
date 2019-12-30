import { connect } from 'react-redux';
import PayrollsComponent from './PayrollsComponent';
import {branchOperations} from '../branches/duck';
import {employeeOperations} from '../employees/duck';
import {payrollOperations} from './duck';


const mapStateToProps = state => {
  return {
      curUser : state.home.userInfo,
      curRole: state.home.role,
      listBranch: state.branch.listBranch,
      listRole: state.employee.listRole,
      listPayroll: state.payroll.listPayroll
  }
};

const mapDispatchToProps = dispatch => {
  const getListBranch = () => dispatch(branchOperations.getListBranch())
  const getListRole = () => dispatch(employeeOperations.getListRole())
  const getListPayroll = (month,year,branch='null',role='null')=> dispatch(payrollOperations.getListPayroll(month,year,branch,role));
  const editPayroll = payroll => dispatch(payrollOperations.editPayroll(payroll));
  const savePayroll = listPayroll => dispatch(payrollOperations.savePayroll(listPayroll));
  return {
      getListBranch,
      getListRole,
      getListPayroll,
      editPayroll,
      savePayroll
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PayrollsComponent);