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
            let employees = action.value.listEmployee;
            for (let i = 0; i < employees.length; i++) {
                if (!String(employees[i].employeeID).includes(action.value.searchContent)
                    && !String(employees[i].employeeName).includes(action.value.searchContent)
                    && !String(employees[i].branchName).includes(action.value.searchContent)
                    && !String(employees[i].roleName).includes(action.value.searchContent)) {
                    employees.splice(i, 1);
                    i--;
                    continue;
                }
            }
            return {
                ...state,
                listEmployee: employees
            }
        }

        default: return state;
    }
}


export default employeeReducer;