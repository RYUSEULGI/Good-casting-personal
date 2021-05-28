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
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(profileRegister.fulfilled, (state, { payload }) => {
            console.log(JSON.stringify(payload));
        });
    },
});

export const profileSelector = (state) => state.profileReducer;

export default profileSlice.reducer;
