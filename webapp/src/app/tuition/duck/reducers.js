import types from './types';


const INITIAL_STATE = {
  student: {
    id: 0,
    name: '',
    classID: ''
  }
}


const tuitionReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case types.CHOOSESTUDENT: {
      return {
        ...state,
        student: action.value
      }
    }

    default: return state;
  }
}

export default tuitionReducer;