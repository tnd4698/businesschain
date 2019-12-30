import types from "./types";

const INITIAL_STATE = {
  listBranch: []
}
const branchReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTBRANCH: {
      return {
        ...state,
        listBranch: action.value
      }
    }

    case types.SEARCH: {
      let listBranch = action.value.listBranch;
      
      for (let i = 0; i < listBranch.length; i++) {
          if (!String(listBranch[i].name).includes(action.value.searchContent)
              && !String(listBranch[i].address).includes(action.value.searchContent)
              && !String(listBranch[i].managerName).includes(action.value.searchContent)
              && !String(listBranch[i].managerPhone).includes(action.value.searchContent)) {
              listBranch.splice(i, 1);
              i--;
              continue;
          }
      }
      return {
          ...state,
          listBranch: listBranch
      }
  }

    default: return state;
  }
}

export default branchReducer;