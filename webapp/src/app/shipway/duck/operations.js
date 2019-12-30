import { default as actions } from './actions';
import { addShipways } from '../../../api/ResourceManagement/resourceManagement'

const saveShipway = listShipway => {
    return dispatch => {
        addShipways(listShipway)
            .then(res => {console.log(listShipway);
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}
export default {
    saveShipway
}