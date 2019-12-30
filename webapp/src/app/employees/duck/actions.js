import { default as types } from './types'

const getListRole = listRole => {
    return {
        type: types.GETLISTROLE,
        value: listRole
    }
}

const getListEmployee = listEmployee => {
    return {
        type: types.GETLISTEMPLOYEE,
        value: listEmployee
    }
}

const search = (listEmployee, searchContent) => {
    return {
        type: types.SEARCH,
        value: {
            listEmployee,
            searchContent
        }
    }
}


export default {
    getListRole,
    getListEmployee,
    search
}