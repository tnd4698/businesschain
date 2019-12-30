import { default as types } from './types'

const getListBranch = listBranch => {
    return {
        type: types.GETLISTBRANCH,
        value: listBranch
    }
}

const search = (listBranch,searchContent) => {
    return {
        type: types.SEARCH,
        value: {
            listBranch,
            searchContent
        }
    }
}

export default {
    getListBranch,
    search
}