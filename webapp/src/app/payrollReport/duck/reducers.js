import types from './types';


const INITIAL_STATE = {
  listPayrollReport: []
}


const payrollReportReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTPAYROLLREPORT: {
      return {
        ...state,
        listPayrollReport: action.value
      }
    }
    default: return state;
  }
}

export default payrollReportReducer;