import types from './types.js';

const getListTuitionReport = listTuitionReport => {
    return {
        type: types.GETLISTTUITIONREPORT,
        value: listTuitionReport
    }
}

export default {
    getListTuitionReport
}