const { default: axios } = require('axios');

const SERVER = 'http://localhost:8080';

const userInfo =
    typeof window !== `undefined`
        ? JSON.parse(localStorage.getItem('USER'))
        : null;

const hireList = (pageRequest) => {
    console.log('service hireList pageRequest: ' + JSON.stringify(pageRequest));
    return axios({
        url: `${SERVER}/hires/list`,
        method: 'post',
        data: pageRequest,
        headers: { Authorization: 'JWT fefege..' },
    });
};

const hireDetail = (id) => {
    return axios({
        url: `${SERVER}/hires/detail/${id}`,
        method: 'get',
        headers: { Authorization: 'JWT fefege..' },
    });
};

const hireRegister = (id) => {
    return axios({
        url: `${SERVER}/hires/detail/${id}`,
        method: 'get',
        headers: { Authorization: 'JWT fefege..' },
    });
};

export default { hireList, hireDetail, hireRegister };
