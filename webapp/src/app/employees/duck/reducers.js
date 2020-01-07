import types from "./types";

const INITIAL_STATE = {
    listRole: [],
    listEmployee: []
}

const employeeReducer = (state = INITIAL_STATE, action) => {
    switch (action.type) {
        case types.GETLISTROLE: {
            return {
                ...state,
                listRole: action.value
            }
        }

        case types.GETLISTEMPLOYEE: {
            return {
                ...state,
                listEmployee: action.value
            }
        }

        case types.SEARCH: {
            let listEmployee = action.value.listEmployee;            
            for (let i = 0; i < listEmployee.length; i++) {
                if (!String(listEmployee[i].employeeID).includes(action.value.searchContent)
                    && !String(listEmployee[i].name).includes(action.value.searchContent)
                    && !String(listEmployee[i].branchName).includes(action.value.searchContent)
                    && !String(listEmployee[i].roleName).includes(action.value.searchContent)
                    ) {
                        listEmployee.splice(i, 1);
                    i--;
                    continue;
                }
            }
            return {
                ...state,
                listEmployee: listEmployee
            }
        }

        default: return state;
    }
}


export default employeeReducer;