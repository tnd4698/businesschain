import { default as actions } from './actions'
import { getMenuItems } from '../../../api/BranchManagement/branchMamagenent'
import { addBill } from '../../../api/BillManagement/billManagement'
import jsPDF from 'jspdf'

const { addMenuItemToBill, removeMenuItemFromBill, resetBill } = actions;

const getListMenuItem = (branchId) => {
    return dispatch => {
        getMenuItems(branchId)
            .then(res => {
                dispatch(actions.getMenuItem(res.data));
            })
    }
}

const formatMoney = num => {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}

const saveBill = bill => {
    return dispatch => {
        addBill(bill)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1') {
                    var doc = new jsPDF('p', 'pt');
                    doc.setFontSize(30);
                    doc.setFont('helvetica');
                    doc.setFontType('bold');
                    doc.text(210, 50, 'Hoa don Coffee');

                    doc.setFontSize(20);
                    doc.setFont('Times New Roman');
                    doc.setFontType('italic');
                    doc.text(50, 100, 'Ten mon');
                    doc.text(200, 100, 'So luong');
                    doc.text(300, 100, 'Don gia (VND)');
                    doc.text(450, 100, 'Thanh tien (VND)');
                    doc.text(50, 110, '_________________________________________________________________');

                    doc.setFontSize(15);
                    doc.setFont('Times New Roman');
                    doc.setFontType('normal');
                    let i = 0;
                    let sum = 0;
                    for (; i < bill.length; i++) {
                        doc.text(50, 130 + 20 * i, bill[i].name);
                        doc.text(200, 130 + 20 * i, String(bill[i].count));
                        doc.text(300, 130 + 20 * i, formatMoney(String(bill[i].price)));
                        doc.text(450, 130 + 20 * i, formatMoney(String(bill[i].count * bill[i].price)));
                        sum += bill[i].count * bill[i].price;
                    }

                    doc.setFontSize(15);
                    doc.setFont('Times New Roman');
                    doc.setFontType('bold');
                    doc.text(50, 130 + 20 * i, 'Tong');
                    doc.text(450, 130 + 20 * i, formatMoney(sum));

                    doc.save(process.env.PUBLIC_URL + '/bill/Bill.pdf');
                }
            })
    }
}

export default {
    getListMenuItem,
    addMenuItemToBill,
    removeMenuItemFromBill,
    resetBill,
    saveBill
}