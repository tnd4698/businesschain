import types from "./types";

const INITIAL_STATE = {
    listNewTimework: [],
    listTimeworkList: [],
    listTimework:[]
}

const timeworkReducer = (state = INITIAL_STATE, action) => {
    switch (action.type) {
        case types.GETLISTNEWTIMEWORK: {
            return {
                ...state,
                listNewTimework: action.value
            }
        }

        case types.GETTIMEWORKLISTS: {
            return {
                ...state,
                listTimeworkList: action.value
            }
        }

        case types.SEARCHTIMEWORK: {
            let listTimeworkList = action.value.listTimeworkList;
            for (let i = 0; i < listTimeworkList.length; i++) {
                if (!String(listTimeworkList[i].date).includes(action.value.searchContent)
                    && !String(listTimeworkList[i].branchName).includes(action.value.searchContent)) {
                    listTimeworkList.splice(i, 1);
                    i--;
                    continue;
                }
            }
            return {
                ...state,
                listTimeworkList: listTimeworkList
            }
        }

        case types.GETTIMEWORKS:{
            return {
                ...state,
                listTimework:action.value
            }
        }

        default: return state;
    }
}


export default timeworkReducer;