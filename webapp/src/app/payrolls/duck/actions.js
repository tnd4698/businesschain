import types from './types.js';

const getListPayroll = listPayroll => {
    return {
        type: types.GETLISTPAYROLL,
        value: listPayroll
    }
}

const editPayroll = payroll =>{
    return {
        type: types.EDITPAYROLL,
        value: payroll
    }
}

const search = (listPayroll,searchContent) =>{
    return {
        type: types.SEARCH,
        value: {
            listPayroll,
            searchContent
        }
    }
}

export default {
    getListPayroll,
    editPayroll,
    search
}