import applyService from '../service/apply.service';
import Swal from 'sweetalert2';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const applicantList = createAsyncThunk(
    'APPLICANTLIST',
    async (pageRequest) => {
        const response = await applyService.applicantist(pageRequest);
        return response.data;
    }
);

export const hireApply = createAsyncThunk('HIRE_APPLY', async (apply) => {
    console.log(apply);
    const response = await applyService.hireApply(apply);
    return response.data;
});

export const rejectApplicant = createAsyncThunk(
    'REJECT_APPLICANT',
    async (id) => {
        const response = await applyService.rejectApplicant(id);
        return response.data;
    }
);

const applySlice = createSlice({
    name: 'apply',
    initialState: {
        pageRequest: {
            page: 1,
            size: 10,
            type: '',
            sort: 'applyId',
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
        flag: true,
    },
    reducers: {
        changeFlag: (state, { payload }) => {
            state.flag = !state.flag;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(hireApply.fulfilled, (state, { payload }) => {
                console.log('payload : ' + JSON.stringify(payload));
            })
            .addCase(hireApply.rejected, (state, { payload }) => {
                console.log(payload);
                if (payload.message.includes('duplicate') || null) {
                    Swal.fire({
                        icon: 'error',
                        title: '이미 지원된 공고입니다.',
                    });
                }
            })
            .addCase(applicantList.fulfilled, (state, { payload }) => {
                console.log(JSON.stringify(payload));
                return {
                    ...state,
                    pageResult: { ...payload },
                };
            })
            .addCase(rejectApplicant.fulfilled, (state, { payload }) => {
                Swal.fire({
                    icon: 'success',
                    title: '불합격 처리되었습니다.',
                });
            });
    },
});

export const applySelector = (state) => state.applyReducer;

export const { changeFlag } = applySlice.actions;

export default applySlice.reducer;
