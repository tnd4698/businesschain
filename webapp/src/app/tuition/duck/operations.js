import { default as actions } from './actions';
import { addTuition } from '../../../api/TuitionManagement/tuitionManagement';
import jsPDF from 'jspdf';

const chooseStudent = student => {
    return dispatch => {
        dispatch(actions.chooseStudent(student));
    }
}

const formatMoney = num => {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}

const saveTuition = tuition => {
    return dispatch => {
        addTuition(tuition)
            .then(res => {
                alert(res.data.returnMessage);
                
                if (res.data.returnCode === '1'){
                    var doc = new jsPDF('p', 'pt');
                    doc.setFontSize(30);
                    doc.setFont('helvetica');
                    doc.setFontType('bold');
                    doc.text(180, 50, 'Phieu thu hoc phi');

                    doc.setFontSize(15);
                    doc.setFont('Times New Roman');
                    doc.setFontType('normal');
                    doc.text(80,100,'Hoc vien');
                    doc.text(210,100,String(tuition.name));
                    doc.text(80,120,'Ma hoc vien');
                    doc.text(210,120,String(tuition.studentID));
                    doc.text(80,140,'Lop');
                    doc.text(210,140,String(tuition.classID));
                    doc.text(80,160,'So tien thu');
                    doc.text(210,160,formatMoney(tuition.totalMoney));

                    doc.save(process.env.PUBLIC_URL + '/tuition/tuition.pdf');
                }
                window.location.reload();
            });
    }
}

export default {
    chooseStudent,
    saveTuition
}