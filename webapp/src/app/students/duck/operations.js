import { default as actions } from './actions'
import {
    getStudents,
    addStudent,
    updateStudent
} from '../../../api/StudentManagement/studentManagement'

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

const getListStudent = (branch = 'null', tuition = 'null', status = '1') => {
    return dispatch => {
        getStudents(branch, tuition, status)
            .then(res => {
                dispatch(actions.getListStudent(res.data));
            })
    }
}

const saveStudent = student => {

    return dispatch => {
        if (!phonenumber(student.phoneNumber))
            return false;

        if (!ValidateEmail(student.email))
            return false;
        addStudent(student)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

const search = (searchContent, branch = 'null', tuition = 'null', status = '1') => {
    return dispatch => {
        getStudents(branch, tuition, status)
            .then(res => {
                dispatch(actions.search(res.data, searchContent));
            })
    }
}

const handleUpdateStudent = student => {

    return dispatch => {
        if (!phonenumber(student.phoneNumber))
            return false;

        if (!ValidateEmail(student.email))
            return false;
        updateStudent(student.studentID, student)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

export default {
    getListStudent,
    saveStudent,
    search,
    handleUpdateStudent
}