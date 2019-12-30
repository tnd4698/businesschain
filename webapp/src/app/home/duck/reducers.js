import types from './types';


const INITIAL_STATE = {
  role: '[ROLE_ANONYMOUS]',
  userInfo : ''
}


const homeReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {

    case types.LOGIN: {
      return {
        ...state,
        role: action.value.role?action.value.role:'[ROLE_ANONYMOUS]',
        userInfo: action.value.userInfo
      }
    }

    case types.LOGOUT: {
      return {
        ...state,
        role: '[ROLE_ANONYMOUS]',
        userInfo : ''
      }
    }

    default: return state;
  }
}

export default homeReducer;