import { default as types } from './types'

const getListClass = listClass => {
    return {
        type: types.GETLISTCLASS,
        value: listClass
    }
}

const getListShift = listShift => {
    return {
        type: types.GETLISTSHIFT,
        value: listShift
    }
}

const search = (listClass, searchContent) => {
    return {
        type: types.SEARCH,
        value: {
            listClass,
            searchContent
        }
    }
}

export default {
    getListClass,
    getListShift,
    search
}