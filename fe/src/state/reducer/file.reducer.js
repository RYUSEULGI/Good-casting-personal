import fileService from '../service/file.service';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const fileRegister = createAsyncThunk(
    'FILE_REGISTER',
    async (formData) => {
        console.log('thunk enter');
        const response = await fileService.fileRegister(formData);

        console.log(response.data);

        // response.data.forEach((idx) => {
        //     console.log(idx);
        //     if (response.data[idx].photoType === false) {
        //         console.log('넌 비디오야');
        //         const videoType = response.data[idx].fileName;
        //         const str = videoType.slice(0, videoType.length - 4);
        //         console.log(str);
        //     }
        // });

        return response.data;
    }
);

export const fileDelete = createAsyncThunk('FILE_DELETE', async (arg) => {
    console.log(arg);
    const response = await fileService.fileDelete(arg);
    console.log('reducer : ' + response.data);
    return response.data;
});

const fileSlice = createSlice({
    name: 'file',
    initialState: {
        fileList: [],
    },
    reducers: {
        deleteFile(state, { payload }) {
            state.fileList = state.fileList.filter(
                (file) => file.uuid !== payload
            );
        },
        setFirstPhotoType(state, { payload }) {
            console.log(payload);
            const chFileProperty = state.fileList.find(
                (file) => file.uuid === payload.uuid
            );
            chFileProperty.first = true;
            chFileProperty.photoType = true;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(fileRegister.fulfilled, (state, { payload }) => {
            console.log(payload);
            return {
                ...state,
                fileList: state.fileList.concat(payload),
            };
        });
    },
});

export const fileSelector = (state) => state.fileReducer;

export const { deleteFile, setFirstPhotoType } = fileSlice.actions;

export default fileSlice.reducer;
