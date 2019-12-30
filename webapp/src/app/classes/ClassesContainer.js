import { connect } from 'react-redux';
import ClassesComponent from './ClassesComponent';

import {branchOperations} from '../branches/duck'
import {classOperations} from './duck'
import {studentOperations} from '../students/duck'
import {employeeOperations} from '../employees/duck'

const mapStateToProps = state => {
    return {
        curUser : state.home.userInfo,
        curRole: state.home.role,
        listBranch: state.branch.listBranch,
        listClass: state.class.listClass,
        listStudent: state.student.listStudent,
        listEmployee: state.employee.listEmployee,
        listShift: state.class.listShift
    }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())
    const getListClass = (branch='null',status='1')=>dispatch(classOperations.getListClass(branch,status));
    const search = (searchContent,branch='null',status='1') => dispatch(classOperations.search(searchContent,branch,status));
    const getListStudent = (branch='null',tuition='null',status='0')=>dispatch(studentOperations.getListStudent(branch,tuition,status));
    const getListEmployee = (branch='null',role='null',status='1')=>dispatch(employeeOperations.getListEmployee(branch,role,status));
    const getListShift = ()=>dispatch(classOperations.getListShift());
    const saveClass = classs=> dispatch(classOperations.saveClass(classs));
    const updateClass = classs=> dispatch(classOperations.handleUpdateClass(classs));
    return {
        getListBranch,
        getListClass,
        search,
        getListStudent,
        getListEmployee,
        getListShift,
        saveClass,
        updateClass
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ClassesComponent);