import { connect } from 'react-redux';
import TuitionReportComponent from './TuitionReportComponent';
import {branchOperations} from '../branches/duck';
import {tuitionReportOperations} from './duck'

const mapStateToProps = (state) => {
  return {
    listBranch: state.branch.listBranch,
    listTuitionReport: state.tuitionReport.listTuitionReport
  }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())   
    const getListTuitionReport = (fromDate,toDate,branch) => dispatch(tuitionReportOperations.getListTuitionReport(fromDate,toDate,branch));
    return {
        getListBranch,
        getListTuitionReport
    }
  };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TuitionReportComponent);