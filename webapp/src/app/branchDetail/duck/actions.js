import { default as types } from './types'

const getBranch = branch => {
    return {
        type: types.GETBRANCH,
        value: branch
    }
}

export default {
    getBranch
}