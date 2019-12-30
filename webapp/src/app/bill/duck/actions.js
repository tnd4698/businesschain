import types from './types.js';

const getMenuItem = (listMenuItem) => {
    return {
        type: types.GETMENUITEM,
        value: listMenuItem
    }
}

const addMenuItemToBill = bill => {
    return {
        type: types.ADDMENUITEMTOBILL,
        value: bill
    }
}

const removeMenuItemFromBill = bill => {
    return {
        type: types.REMOVEMENUITEMFROMBILL,
        value: bill
    }
}

const resetBill = () =>{
    return {
        type: types.RESETBILL,
        value: ''
    }
}

export default {
    getMenuItem,
    addMenuItemToBill,
    removeMenuItemFromBill,
    resetBill
}