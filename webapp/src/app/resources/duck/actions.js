import { default as types } from './types'

const getListResource = listResource=>{
    return {
        type: types.GETLISTRESOURCE,
        value: listResource
    }
}

const search = (listResource, searchContent) => {
    return {
        type: types.SEARCH,
        value: {
            listResource,
            searchContent
        }
    }
}

export default {
    getListResource,
    search
}