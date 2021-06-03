import profileService from '../service/profile.service';
import uuid from 'uuid/dist/v4';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const profileList = createAsyncThunk(
    'PROFILE_LIST',
    async (pageRequest) => {
        console.log(
            'reducer profileList() pageRequest: ' + JSON.stringify(pageRequest)
        );
        const response = await profileService.profileList(pageRequest);

        return response.data;
    }
);

export const profileRegister = createAsyncThunk(
    'PROFILE_REGISTER',
    async (arg) => {
        const response = await profileService.profileRegister(arg);
        return response.data;
    }
);

const profileSlice = createSlice({
    name: 'profile',
    initialState: {
        profileList: [],
        careerList: [],
        fileList: [],
        pageRequest: {
            page: 1,
            size: 10,
            type: '',
            sort: 'profileId',
            searchCond: {
                afrom: 0,
                ato: 0,
                rKeyword: '',
                gKeyword: '',
                wfrom: 0,
                wto: 0,
                hfrom: 0,
                hto: 0,
            },
            file: {
                fileName: '',
                uuid: '',
            },
        },
        pageResult: {
            pageList: [],
            dtoList: [],
            page: 1,
            size: 10,
            totalPage: 0,
            start: 0,
            end: 0,
            prev: false,
            next: false,
            totalElement: 0,
        },
    },
    reducers: {
        addCareer(state, { payload }) {
            state.careerList.push({
                uuid: uuid(),
                year: payload.year,
                genre: payload.genre,
                title: payload.title,
                contents: payload.contents,
            });
        },
        deleteCareer(state, { payload }) {
            state.careerList = state.careerList.filter(
                (career) => career.uuid !== payload
            );
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(profileList.fulfilled, (state, { payload }) => {
                console.log('payload :' + JSON.stringify(payload));

                return {
                    ...state,
                    pageResult: { ...payload },
                };
            })
            .addCase(profileRegister.fulfilled, (state, { payload }) => {
                console.log(payload);
            });
    },
});
export const profileSelector = (state) => state.profileReducer;
export const { addCareer, setCareer, deleteCareer } = profileSlice.actions;

export default profileSlice.reducer;
