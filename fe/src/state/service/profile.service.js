const { default: axios } = require('axios');

const SERVER = 'http://localhost:8080';

const profileRegister = (arg) => {
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

const getMyProfileList = (pageRequest) => {
    console.log('service hireList pageRequest: ' + JSON.stringify(pageRequest));

    return axios({
        url: `${SERVER}/profiles/myList`,
        method: 'post',
        data: {
            page: pageRequest.page,
            size: pageRequest.size,
            sort: pageRequest.sort,
        },
        headers: {
            Authorization: localStorage.getItem('TOKEN'),
        },
    });
};

export default { profileRegister, fileRegister, getMyProfileList };
