import types from './types.js';

const getListStudent = listStudent => {
    return {
        type: types.GETLISTSTUDENT,
        value: listStudent
    }
}

const search = (listStudent, searchContent) => {
    return {
        type: types.SEARCH,
        value: {
            listStudent,
            searchContent
        }
    }
}

export default {
    getListStudent,
    search
}