import React, { useCallback } from 'react';
import { fileRegister, fileSelector } from '../../state/reducer/file.reducer';
import { useDispatch, useSelector } from 'react-redux';

import cameraIcon from '../../assets/image/ico_camera.svg';

const FileUpload = ({ setImages }) => {
    const dispatch = useDispatch();

    const fileState = useSelector(fileSelector);

    const handleSelectedImg = useCallback((e) => {
        e.preventDefault();

        const formData = new FormData();
        const imgFile = e.target.files;
        const imgUrl = URL.createObjectURL(imgFile[0]);

        for (let i = 0; i < imgFile.length; i++) {
            formData.append('uploadFiles', imgFile[i]);
            console.log(imgFile[i]);
        }

        dispatch(fileRegister(formData));
        setImages(imgUrl);
    });

    return (
        <>
            <div className="avatar-wrapper">
                <label
                    htmlFor="fileUpload"
                    className="mb-0 font-size-4 text-smoke"
                >
                    {setImages === null ? (
                        <img
                            className="pic_basic btn_custom_file_camera"
                            src={cameraIcon}
                        />
                    ) : (
                        fileState.fileList.map((file) => {
                            return (
                                <img
                                    className="pic_basic btn_custom_file_camera thumnail-size"
                                    src={`http://localhost:8080/files/display?fileName=s_${file.uuid}_${file.fileName}`}
                                />
                            );
                        })
                    )}
                    <input
                        type="file"
                        accept="image/*"
                        id="fileUpload"
                        className="sr-only"
                        className="file-upload"
                        onChange={handleSelectedImg}
                    />
                </label>
            </div>
        </>
    );
};

export default FileUpload;
