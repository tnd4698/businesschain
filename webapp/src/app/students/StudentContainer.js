import { connect } from 'react-redux';
import StudentsComponent from './StudentsComponent';
import {studentOperations} from './duck';
import {branchOperations} from '../branches/duck';
import {tuitionOperations} from '../tuition/duck';

const mapStateToProps = state => {
  return {
    curUser: state.home.userInfo,
    curRole: state.home.role,
    listStudent: state.student.listStudent,
    listBranch: state.branch.listBranch,
    
  }
};

const mapDispatchToProps = dispatch => {
    const getListStudent = (branch='null',tuition='null',status='1') => {
        dispatch(studentOperations.getListStudent(branch,tuition,status));
    }
    const getListBranch = ()=>dispatch(branchOperations.getListBranch());
    const saveStudent = student => dispatch(studentOperations.saveStudent(student));
    const search = (searchContent,branch='null',tuition='null',status='1') => dispatch(studentOperations.search(searchContent,branch,tuition,status));
    const updateStudent = student => dispatch(studentOperations.handleUpdateStudent(student));
    const toggleTuition = student => dispatch(tuitionOperations.chooseStudent(student));
    return {
        getListStudent,
        getListBranch,
        saveStudent,
        search,
        updateStudent,
        toggleTuition
    }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(StudentsComponent);