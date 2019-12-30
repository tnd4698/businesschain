import { default as actions } from './actions'
import {
    getClasses,
    getShifts,
    addClass,
    updateClass
} from '../../../api/ClassManagement/classManagement'

const getListClass = (branch='null',status='1')=>{
    return dispatch => {
        getClasses(branch,status)
        .then(res=>{
            dispatch(actions.getListClass(res.data));
        })
    }
}

const getListShift = ()=>{
    return dispatch => {
        getShifts()
        .then(res=>{
            dispatch(actions.getListShift(res.data));
        })
    }
}

const search = (searchContent, branch = 'null', status = '1') => {
    return dispatch => {
        getClasses(branch, status)
            .then(res => {
                dispatch(actions.search(res.data, searchContent));
            })
    }
}

const saveClass = classs => {
    return dispatch => {
        addClass(classs)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

const handleUpdateClass = classs => {
    return dispatch => {
        updateClass(classs.classID,classs)
            .then(res => {
                alert(res.data.returnMessage);
                if (res.data.returnCode === '1')
                    window.location.reload();
            })
    }
}

export default {
    getListClass,
    getListShift,
    search,
    saveClass,
    handleUpdateClass
}