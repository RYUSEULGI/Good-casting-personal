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

const profileSlice = createSlice({
    name: 'profile',
    initialState: {
        profile: [],
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
            .addCase(fileRegister.fulfilled, (state, {payload}) => {
                console.log(payload.first);
                return {
                    ...state,
                    // fileList: [{
                    //     ...payload,
                    //     first: !payload.first,
                    //     photoType: !payload.photoType,
                    //     }
                    // ]
                    fileList: [...payload],
                };
            });
    },
});

export const profileSelector = (state) => state.profileReducer;

export const { addCareer, setCareer, deleteCareer } = profileSlice.actions;

export default profileSlice.reducer;
