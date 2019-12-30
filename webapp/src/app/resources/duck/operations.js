import { default as actions } from './actions'
import {
    getResources,
    updateResource,
    addResource
} from '../../../api/ResourceManagement/resourceManagement'

const getListResource = (branch = 'null', type = 'null', status = 1) => {
    return dispatch => {
        getResources(branch, type, status)
            .then(res => {
                dispatch(actions.getListResource(res.data));
            })
    }
}

const search = (searchContent, branch = 'null', role = 'null', status = '1') => {
    return dispatch => {
        getResources(branch, role, status)
            .then(res => {
                dispatch(actions.search(res.data, searchContent));
            })
    }
}

const handleUpdateResource = resource => {
    return dispatch => {
        updateResource(resource.resourceID, resource)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode ==='1')
                    window.location.reload();
            })
    }
}

const saveResource= resource =>{
    return dispatch=>{
        addResource(resource)
        .then(res => {
            alert(res.data.returnMessage);
        })
    }
}

export default {
    getListResource,
    search,
    handleUpdateResource,
    saveResource
}