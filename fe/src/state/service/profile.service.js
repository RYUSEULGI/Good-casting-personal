const { default: axios } = require('axios');

const SERVER = 'http://localhost:8080';

const profileRegister = (arg) => {
    console.log('service hireList pageRequest: ' + JSON.stringify(arg));
    return axios({
        url: `${SERVER}/profiles/register`,
        method: 'post',
        data: arg,
        headers: {
            // 'Content-Type': 'multipart/form-data',
            Authorization: localStorage.getItem('TOKEN'),
        },
    });
};

const fileRegister = (arg) => {
    return axios({
        url: `${SERVER}/files/register`,
        method: 'post',
        data: arg,
        headers: {
            'Content-Type': 'multipart/form-data',
            Authorization: localStorage.getItem('TOKEN'),
        },
    });
};

export default { profileRegister, fileRegister };
