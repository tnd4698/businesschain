import types from './types.js';

const getListBillReport = listBillReport => {
    return {
        type: types.GETLISTBILLREPORT,
        value: listBillReport
    }
}

export default {
    getListBillReport
}