import profileService from '../service/profile.service';
import uuid from 'uuid/dist/v4';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const profileRegister = createAsyncThunk(
    'PROFILE_REGISTER',
    async (arg) => {
        const response = await profileService.profileRegister(arg);
        return response.data;
    }
);

export const fileRegister = createAsyncThunk('FILE_REGISTER', async (arg) => {
    const response = await profileService.fileRegister(arg);
    return response.data;
});

export const getMyProfileList = createAsyncThunk(
    'GET_MY_PROFILE',
    async (pageRequest) => {
        const response = await profileService.getMyProfileList(pageRequest);

        if (pageRequest.page === 0) {
            return null;
        }

        console.log(response.data);
        return response.data;
    }
);

const profileSlice = createSlice({
    name: 'profile',
    initialState: {
        profileList: [],
        careerList: [],
        fileList: [],
    },
    reducers: {
        addCareer(state, { payload }) {
            state.careerList.push({
                uuid: uuid(),
                year: payload.year,
                gerne: payload.gerne,
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
            .addCase(profileRegister.fulfilled, (state, { payload }) => {
                console.log(payload);
            })
            .addCase(fileRegister.fulfilled, (state, { payload }) => {
                return {
                    ...state,
                    fileList: [
                        {
                            ...payload[0],
                            first: !payload[0].first,
                            photoType: !payload[0].photoType,
                        },
                    ],
                };
            });
    },
});

export const profileSelector = (state) => state.profileReducer;

export const { addCareer, setCareer, deleteCareer } = profileSlice.actions;

export default profileSlice.reducer;
