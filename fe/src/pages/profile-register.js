import React, { useState, useCallback, useEffect } from 'react';
import ProfileCareer from '../components/Profile/ProfileCareer';
import { useDispatch, useSelector } from 'react-redux';
import {
    fileRegister,
    profileRegister,
    profileSelector,
} from '../state/reducer/profile.reducer';
import PageWrapper from '../components/PageWrapper';
import Swal from 'sweetalert2'

import cameraIcon from '../assets/image/ico_camera.svg';

import '../scss/css/fileUpload.css';
import { actorSelctor } from '../state/reducer/actor.reducer';

const sweetalert = (icon, title, text, footer) => {
    Swal.fire({
        icon: icon,
        title: title,
        text: text,
        footer: footer,
    })
}

const ProfileRegister = () => {
    const dispatch = useDispatch();

    const profileState = useSelector(profileSelector);
    const actorState = useSelector(actorSelctor);

    const [inputs, setInputs] = useState({});
    const [image, setImages] = useState(null);

    useEffect(() => {
        setInputs({
            ...inputs,
            actor: actorState.actor,
            careers: profileState.careerList,
            files: profileState.fileList,
        });
    }, [profileState, actorState]);

    const handleSubmit = (e) => {
        e.preventDefault();
        dispatch(profileRegister(inputs));
        Swal.fire({
            icon: 'success',
            title: '프로필이 등록되었습니다.',
        })
    };

    const handleChange = useCallback(
        (e) => {
            setInputs({
                ...inputs,
                [e.target.name]: e.target.value,
            });
        },
        [inputs]
    );

    const handleSelectedImg = useCallback((e) => {
        e.preventDefault();

        const formData = new FormData();

        const imgFile = e.target.files[0];
        const imgUrl = URL.createObjectURL(imgFile);

        formData.append('uploadFiles', imgFile);
        dispatch(fileRegister(formData));
        setImages(imgUrl);
    });

    return (
        <>
            <PageWrapper
                headerConfig={{
                    button: 'profile',
                    isFluid: true,
                    bgClass: 'bg-default',
                    reveal: false,
                }}
            >
                <div className="mt-24 mt-lg-31" id="dashboard-body">
                    <div className="container">
                        <div className="mb-15 mb-lg-23">
                            <div className="row">
                                <div className="col-xxxl-9 px-lg-13 px-6">
                                    <h5 className="font-size-6 font-weight-semibold mb-11">
                                        프로필 등록
                                    </h5>
                                    <div className="contact-form bg-white shadow-8 rounded-4 pl-sm-10 pl-4 pr-sm-11 pr-4 pt-15 pb-13">
                                        <div className="upload-file mb-16 text-center">
                                            <div
                                                id="userActions"
                                                className="square-144 m-auto px-6 mb-7"
                                            >
                                                <label
                                                    htmlFor="fileUpload"
                                                    className="mb-0 font-size-4 text-smoke"
                                                >
                                                    {image === null ? (
                                                        <img
                                                            className="pic_basic btn_custom_file_camera"
                                                            src={cameraIcon}
                                                        />
                                                    ) : (
                                                        profileState.fileList.map(
                                                            (file) => {
                                                                return (
                                                                    <img
                                                                        className="pic_basic btn_custom_file_camera thumnail-size"
                                                                        src={`http://localhost:8080/files/display?fileName=s_${file.uuid}_${file.fileName}`}
                                                                    />
                                                                );
                                                            }
                                                        )
                                                    )}
                                                </label>
                                                <input
                                                    type="file"
                                                    accept="image/*"
                                                    id="fileUpload"
                                                    className="sr-only"
                                                    onChange={handleSelectedImg}
                                                />
                                            </div>
                                            <p>※ 프로필사진을 등록해주세요</p>
                                        </div>
                                        <form onSubmit={handleSubmit}>
                                            <fieldset>
                                                <div className="col-md-12">
                                                    <div className="form-group">
                                                        <label
                                                            htmlFor="aboutTextarea"
                                                            className="d-block text-black-2 font-size-4 font-weight-semibold mb-4"
                                                        >
                                                            동영상 등록하기
                                                        </label>
                                                        <input
                                                            type="file"
                                                            accept="video/mp4, video/x-m4v, video/avi"
                                                            id="fileUpload"
                                                            className="sr-only"
                                                            onChange={
                                                                handleSelectedImg
                                                            }
                                                        />
                                                    </div>
                                                </div>
                                                <div className="col-md-12">
                                                    <div className="form-group">
                                                        <label
                                                            htmlFor="aboutTextarea"
                                                            className="d-block text-black-2 font-size-4 font-weight-semibold mb-4"
                                                        >
                                                            경력
                                                        </label>
                                                        <ProfileCareer />
                                                    </div>
                                                </div>
                                                <div className="col-md-12">
                                                    <div className="form-group">
                                                        <label
                                                            htmlFor="aboutTextarea"
                                                            className="d-block text-black-2 font-size-4 font-weight-semibold mb-4"
                                                        >
                                                            자기소개
                                                        </label>
                                                        <textarea
                                                            name="contents"
                                                            id="aboutTextarea"
                                                            cols="30"
                                                            rows="7"
                                                            className="border border-mercury text-gray w-100 pt-4 pl-6"
                                                            placeholder="간단한 자기소개를 입력해주세요"
                                                            onChange={
                                                                handleChange
                                                            }
                                                            value={
                                                                inputs.contents
                                                            }
                                                        ></textarea>
                                                    </div>
                                                </div>
                                                <div className="row">
                                                    <button className="btn btn-green btn-h-60 text-white min-width-px-210 rounded-5 text-uppercase btn-center">
                                                        등록하기
                                                    </button>
                                                </div>
                                            </fieldset>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </PageWrapper>
        </>
    );
};

export default ProfileRegister;
