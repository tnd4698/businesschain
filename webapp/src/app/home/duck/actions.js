import types from './types.js';

const login = (userInfo,role) => {
    return {
        type: types.LOGIN,
        value: {userInfo,role}
    }
}

const logout = () => {
    return {
        type: types.LOGOUT,
        value: ''
    }
}


export default {
    login,
    logout
}