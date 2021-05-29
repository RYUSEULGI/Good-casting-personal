import { profileService } from '../service/profile.service';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const profileRegister = createAsyncThunk(
    'PROFILE_REGISTER',
    async (arg) => {
        console.log(arg);
        const response = await profileService.profileRegister();
        return response.data;
    }
);

const profileSlice = createSlice({
    name: 'profile',
    initialState: {
        profile: [],
        careerList: [],
    },
    reducers: {
        addCareer(state, { payload }) {
            state.careerList.push({ text: payload });
        },
        deleteCareer(state, { payload }) {
            state.careerList = state.careerList.filter(
                (career) => career.id !== payload
            );
        },
        setCareer(state, { payload }) {
            console.log('payload test : ' + JSON.stringify(payload));
            state.careerList = state.careerList;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(profileRegister.fulfilled, (state, { payload }) => {
            console.log(JSON.stringify(payload));
        });
    },
});

export const profileSelector = (state) => state.profileReducer;

export const { addCareer, setCareer } = profileSlice.actions;

export default profileSlice.reducer;
