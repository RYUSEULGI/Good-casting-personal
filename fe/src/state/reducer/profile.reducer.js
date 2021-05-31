import { profileService } from '../service/profile.service';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const profileRegister = createAsyncThunk(
    'PROFILE_REGISTER',
    async (arg, state) => {
        console.log(arg);
        console.log(state.careerList);
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
            state.careerList.push({
                year: payload.year,
                gerne: payload.gerne,
                title: payload.title,
                contents: payload.contents,
            });
        },
        deleteCareer(state, { payload }) {
            console.log('삭제');
            console.log(payload);
            state.careerList = state.careerList.filter(
                (career) => career.id !== payload
            );
        },
        setCareer(state, { payload }) {
            console.log('payload test : ' + JSON.stringify(payload));
            console.log(payload.title);
            state.careerList.push();
            // state.careerList = state.careerList.push({});
        },
    },
    extraReducers: (builder) => {
        builder.addCase(profileRegister.fulfilled, (state, { payload }) => {
            console.log(JSON.stringify(payload));
        });
    },
});

export const profileSelector = (state) => state.profileReducer;

export const { addCareer, setCareer, deleteCareer } = profileSlice.actions;

export default profileSlice.reducer;
