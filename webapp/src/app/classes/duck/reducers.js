import types from "./types";

const INITIAL_STATE = {
    listClass: [],
    listShift: []
}

const employeeReducer = (state = INITIAL_STATE, action) => {
    switch (action.type) {
        case types.GETLISTCLASS: {
            return {
                ...state,
                listClass: action.value
            }
        }

        case types.GETLISTSHIFT: {
            return {
                ...state,
                listShift: action.value
            }
        }

        case types.SEARCH: {
            let listClass = action.value.listClass;

            for (let i = 0; i < listClass.length; i++) {
                if (!String(listClass[i].classID).includes(action.value.searchContent)
                    && !String(listClass[i].branchName).includes(action.value.searchContent)) {
                    listClass.splice(i, 1);
                    i--;
                    continue;
                }
            }
            return {
                ...state,
                listClass: listClass
            }
        }

        default: return state;
    }
}


export default employeeReducer;