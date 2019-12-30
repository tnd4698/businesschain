import types from "./types";

const INITIAL_STATE = {
  listMenuItem: [],
  billDetails: []
}
const billReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETMENUITEM: {
      return {
        ...state,
        listMenuItem: action.value
      }
    }

    case types.ADDMENUITEMTOBILL: {
      let billDetails = state.billDetails;
      let index = -1;
      for (let i = 0; i < billDetails.length; i++) {
        if (billDetails[i].itemMenu === action.value.itemMenu) {
          billDetails[i].count++;
          index = i;
          break;
        }
      }
      if (index === -1)
        billDetails.push(action.value);
      return {
        ...state,
        billDetails
      }
    }

    case types.REMOVEMENUITEMFROMBILL: {
      let billDetails = state.billDetails;
      let index = -1;
      for (let i = 0; i < billDetails.length; i++) {
        if (billDetails[i].itemMenu === action.value.itemMenu) {
          billDetails[i].count--;
          if (billDetails[i].count <= 0)
            index = i;
          break;
        }
      }
      if (index !== -1)
        billDetails.splice(index, 1);
      return {
        ...state,
        billDetails
      }
    }

    case types.RESETBILL: {
      return {
        ...state,
        billDetails:[]
      }
    }

    default: return state;
  }
}

export default billReducer;