import types from './types';


const INITIAL_STATE = {
  listStudent : []
}


const studentReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.GETLISTSTUDENT:{
      return {
        ...state,
        listStudent: action.value
      }
    }
    
    case types.SEARCH: {
      let listStudent = action.value.listStudent;
      
      for (let i = 0; i < listStudent.length; i++) {
          if (!String(listStudent[i].studentID).includes(action.value.searchContent)
              && !String(listStudent[i].name).includes(action.value.searchContent)
              && !String(listStudent[i].classID).includes(action.value.searchContent)
              && !String(listStudent[i].branchName).includes(action.value.searchContent)) {
                listStudent.splice(i, 1);
              i--;
              continue;
          }
      }
      return {
          ...state,
          listStudent: listStudent
      }
  }

    default: return state;
  }
}

export default studentReducer;