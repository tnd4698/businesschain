import types from './types.js';

const chooseStudent = student => {
    return {
        type: types.CHOOSESTUDENT,
        value: student
    }
}

export default {
    chooseStudent
}