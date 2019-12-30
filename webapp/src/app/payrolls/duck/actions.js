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

export default {
    getListPayroll,
    editPayroll
}