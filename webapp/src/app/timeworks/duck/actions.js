import { default as types } from './types'

const getListNewTimework = listNewTimework => {
    return {
        type: types.GETLISTNEWTIMEWORK,
        value: listNewTimework
    }
}

const getTimeworkLists = timeworkLists => {
    return {
        type: types.GETTIMEWORKLISTS,
        value: timeworkLists
    }
}

const search = (listTimeworkList,searchContent) => {
    return {
        type: types.SEARCH,
        value: {
            listTimeworkList,
            searchContent
        }
    }
}

const getTimeworks = timeworks => {
    return {
        type: types.GETTIMEWORKS,
        value: timeworks
    }
}

export default {
    getListNewTimework,
    getTimeworkLists,
    search,
    getTimeworks
}