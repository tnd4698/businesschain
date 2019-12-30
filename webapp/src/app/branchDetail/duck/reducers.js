import types from "./types";

const INITIAL_STATE = {
  branch: {}
}

const branchDetailReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETBRANCH: {
      return {
        ...state,
        branch: action.value
      }
    }

    default: return state;
  }
}

export default branchDetailReducer;