import { connect } from 'react-redux';
import TuitionComponent from './TuitionComponent';

import {tuitionOperations} from './duck';
import {studentOperations} from '../students/duck'

const mapStateToProps = (state) => {
  return {
    listStudent : state.student.listStudent,
    curUser: state.home.userInfo,
    student: state.tuition.student
  }
};

const mapDispatchToProps = dispatch => {

  const chooseStudent = student => dispatch(tuitionOperations.chooseStudent(student));
  const getListStudent = (branch='null',tuition='0',status='1') => dispatch(studentOperations.getListStudent(branch,tuition,status));
  const saveTuition = tuition => dispatch(tuitionOperations.saveTuition(tuition));
  return {
    chooseStudent,
    getListStudent,
    saveTuition
  }
};


export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TuitionComponent);