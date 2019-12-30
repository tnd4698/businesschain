import { connect } from 'react-redux';
import ProfitReportComponent from './ProfitReportComponent';
import {branchOperations} from '../branches/duck';
import {profitReportOperations} from './duck'

const mapStateToProps = (state) => {
  return {
    listBranch: state.branch.listBranch,
    listProfitReport: state.profitReport.listProfitReport
  }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())   
    const getListProfitReport = (fromMonth, fromYear, toMonth, toYear,branch) => dispatch(profitReportOperations.getListProfitReport(fromMonth, fromYear, toMonth, toYear,branch));
    return {
        getListBranch,
        getListProfitReport
    }
  };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ProfitReportComponent);