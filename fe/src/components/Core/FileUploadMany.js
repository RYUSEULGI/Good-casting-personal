import React, { useCallback, useEffect } from 'react';
import { fileRegister, fileSelector } from '../../state/reducer/file.reducer';
import { useDispatch, useSelector } from 'react-redux';
import { deleteFile } from '../../state/reducer/file.reducer';
import Swal from 'sweetalert2';

const sweetalert = (icon, title, text, footer) => {
    Swal.fire({
        icon: icon,
        title: title,
        text: text,
        footer: footer,
    });
};

const FileUploadMany = ({ image }) => {
    const dispatch = useDispatch();

    const fileState = useSelector(fileSelector);

    const handleSelectedImgs = useCallback((e) => {
        if (image !== null) {
            e.preventDefault();

            const formData = new FormData();

            const imgFile = e.target.files;
            console.log(imgFile);
            const imgUrl = URL.createObjectURL(imgFile[0]);

            for (let i = 0; i < imgFile.length; i++) {
                formData.append('uploadFiles', imgFile[i]);

                const fileName = imgFile[i].name;
                if (fileName.includes('.mp4')) {
                    fileName = fileName.slice(0, fileName.length - 4);
                }

                console.log(imgFile[i].name);
            }

            console.log(...formData);

            // dispatch(fileRegister(formData));
        } else {
            Swal.fire({
                icon: 'error',
                title: '프로필 사진이 없습니다!',
                text: '프로필 사진을 등록해주세요',
            });
        }
    });

    useEffect(() => {
        console.log(fileState.fileList);
    }, [fileState.fileList]);

    return (
        <>
            <div id="dropzone">
                <label
                    htmlFor="fileUpload"
                    className="mb-0 font-size-4 text-smoke"
                ></label>
                {fileState.fileList.map((file) => {
                    return (
                        <>
                            <img
                                onClick={(e) => {
                                    e.preventDefault();
                                    console.log(file.uuid);
                                    dispatch(deleteFile(file.uuid));
                                }}
                                className="thumnails-size"
                                src={`http://localhost:8080/files/display?fileName=s_${file.uuid}_${file.fileName}`}
                            />
                            <p className="thumnails-delBtn">삭제하기</p>
                        </>
                    );
                })}
                <input
                    multiple="multiple"
                    accept="image/*, video/mp4"
                    id="fileUpload"
                    type="file"
                    name="filename[]"
                    onChange={handleSelectedImgs}
                />
            </div>
        </>
    );
};

export default FileUploadMany;
