const { default: axios } = require('axios');

const SERVER = 'http://localhost:8080';

const profileRegister = (arg) => {
    console.log('service hireList pageRequest: ' + JSON.stringify(arg));
    return axios({
        url: `${SERVER}/profiles/register`,
        method: 'post',
        data: arg,
        headers: { Authorization: localStorage.getItem('token') },
    });
};

export default { profileRegister };
