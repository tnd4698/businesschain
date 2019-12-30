import { default as actions } from './actions'
import { getRole, getUser } from '../../../api/Home/home'
import axios from 'axios'


const login = (credentials) => {
    return dispatch => {
        const data = new FormData();
        data.append("username", credentials.username);
        data.append("password", credentials.password);
        axios({
            method: "POST",
            url: '/login',
            data: data
        })
            .finally(res => {
                getRole()
                .then(res=>{
                    const role = res.data;
                    getUser()
                    .then(res=>{
                        dispatch(actions.login(res.data,role));
                    })
                })
                
            }
            )
    }
}

const logout = () => {
    return dispatch => {
        axios({
            headers: {"Access-Control-Allow-Origin": "*"},
            method: "POST",
            url: '/logout',
            data:null
        })
            .finally(
                () => {
                    dispatch(actions.logout());
                    setTimeout(()=>localStorage.clear(),1000)
                }
            )
    }
}

export default {
    login,
    logout
}