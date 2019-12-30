import types from './types.js';

const getListProfitReport = listProfitReport => {
    return {
        type: types.GETLISTPROFITREPORT,
        value: listProfitReport
    }
}

export default {
    getListProfitReport
}