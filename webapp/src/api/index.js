import axios from 'axios';
import { message } from 'antd';

export function httpGet(url, body) {
    return callApi(url, 'GET', body);
}

export function httpPost(url, body) {
    return callApi(url, 'POST', body);
}

export function httpPut(url, body) {
    return callApi(url, 'PUT', body);
}

function callApi(url, method, body = null) {
    const headers = { 'Content-Type': 'application/json' };
    const meta = {
        method,
        headers,
    };
    if (body) {
        meta.data = JSON.stringify(body);
    }
    return axios(`${url}`, meta)
        .then(response => {

            return response;
        }).catch((error) => {

            message.error(error.response.statusText);
            return false;
        });
}