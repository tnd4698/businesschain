import { default as actions } from './actions'
import { getRoles } from '../../../api/AdminManagement/adminManagement'
import { getEmployees, addEmployee, updateEmployee } from '../../../api/EmployeeManagement/employeeManagement'

function phonenumber(inputtxt) {
    var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    if (inputtxt.match(phoneno)) {
        return true;
    }
    else {
        alert("Not a valid Phone Number");
        return false;
    }
}
function ValidateEmail(inputText) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (inputText.match(mailformat)) {
        return true;
    }
    else {
        alert("You have entered an invalid email address!");
        return false;
    }
}

const getListRole = () => {
    return dispatch => {
        getRoles()
            .then(res => {
                dispatch(actions.getListRole(res.data));
            })
    }
}

const getListEmployee = (branch = 'null', role = 'null', status = '1') => {
    return dispatch => {
        getEmployees(branch, role, status)
            .then(res => {
                dispatch(actions.getListEmployee(res.data));
            })
    }
}

const saveEmployee = employee => {
    return dispatch => {

        if (!phonenumber(employee.phoneNumber))
            return false;

        if (!ValidateEmail(employee.email))
            return false;
        addEmployee(employee)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

const updateEmployeeInfo = (employeeID, newEmployee) => {
    return dispatch => {

        if (!phonenumber(newEmployee.phoneNumber))
            return false;

        if (!ValidateEmail(newEmployee.email))
            return false;

        updateEmployee(employeeID, newEmployee)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

const search = (searchContent, branch = 'null', role = 'null', status = '1') => {
    return dispatch => {
        getEmployees(branch, role, status)
            .then(res => {
                dispatch(actions.search(res.data, searchContent));
            })
    }
}

export default {
    getListRole,
    getListEmployee,
    saveEmployee,
    updateEmployeeInfo,
    search
}