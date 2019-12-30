import types from './types';


const INITIAL_STATE = {
  listTuitionReport: []
}


const tuitionReportReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTTUITIONREPORT: {
      return {
        ...state,
        listTuitionReport: action.value
      }
    }
    default: return state;
  }
}

export default tuitionReportReducer;