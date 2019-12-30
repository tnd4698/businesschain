import types from './types';


const INITIAL_STATE = {
  listProfitReport: []
}


const profitReportReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTPROFITREPORT: {
      return {
        ...state,
        listProfitReport: action.value
      }
    }
    default: return state;
  }
}

export default profitReportReducer;