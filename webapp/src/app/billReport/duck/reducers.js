import types from './types';


const INITIAL_STATE = {
  listBillReport: []
}


const billReportReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTBILLREPORT: {
      return {
        ...state,
        listBillReport: action.value
      }
    }
    default: return state;
  }
}

export default billReportReducer;