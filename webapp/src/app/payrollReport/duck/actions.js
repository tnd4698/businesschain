import types from './types.js';

const getListPayrollReport = listPayrollReport => {
    return {
        type: types.GETLISTPAYROLLREPORT,
        value: listPayrollReport
    }
}

export default {
    getListPayrollReport
}