import types from './types';


const INITIAL_STATE = {
  listPayroll: []
}


const payrollReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTPAYROLL: {
      return {
        ...state,
        listPayroll: action.value
      }
    }

    case types.EDITPAYROLL:{
      const listPayroll = state.listPayroll;
      const payroll = action.value;
      listPayroll.map(cur=>{
        if(cur.employee === payroll.value) {
          cur = payroll;
          return cur;
        }
      });
      return {
        ...state,
        listPayroll:listPayroll
      }
    }

    default: return state;
  }
}

export default payrollReducer;