import { default as actions } from './actions';
import { addSpend } from '../../../api/BudgetManagement/budgetManagement'

const saveSpend = spend => {
    return dispatch => {
        addSpend(spend)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}
export default {
    saveSpend
}