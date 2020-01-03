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

    case types.SEARCH: {
      let listPayroll = action.value.listPayroll;
      for (let i = 0; i < listPayroll.length; i++) {
          if (!String(listPayroll[i].employeeID).includes(action.value.searchContent)
              && !String(listPayroll[i].employeeName).includes(action.value.searchContent)
              && !String(listPayroll[i].salary).includes(action.value.searchContent)
              && !String(listPayroll[i].absent).includes(action.value.searchContent)) {
                listPayroll.splice(i, 1);
              i--;
              continue;
          }
      }
      return {
          ...state,
          listPayroll: listPayroll
      }
  }

    default: return state;
  }
}

export default payrollReducer;