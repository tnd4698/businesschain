import { default as actions } from './actions';
import { addImport } from '../../../api/ResourceManagement/resourceManagement'

const saveImport = listImport => {
    return dispatch => {
        addImport(listImport)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}
export default {
    saveImport
}