package shop.ryuseulgi.goodCasting.file.service;

import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;

import java.io.File;
import java.util.List;

public interface FileService {
    void extractVideoThumbnail(File file) throws Exception;

    default FileDTO entity2Dto(FileVO fileVO) {
        return FileDTO.builder()
                .fileId(fileVO.getFileId())
                .fileName(fileVO.getFileName())
                .uuid(fileVO.getUuid())
                .first(fileVO.isFirst())
                .photoType(fileVO.isPhotoType())
                .build();
    }

    default FileDTO entity2DtoHire(FileVO fileVO){
        return FileDTO.builder()
                .fileId(fileVO.getFileId())
                .fileName(fileVO.getFileName())
                .uuid(fileVO.getUuid())
                .first(fileVO.isFirst())
                .photoType(fileVO.isPhotoType())
                .hire(HireDTO.builder()
                        .hireId(fileVO.getHire().getHireId()).build())
                .build();
    }

    default FileDTO entity2DtoAll(FileVO fileVO) {
        return FileDTO.builder()
                .fileId(fileVO.getFileId())
                .fileName(fileVO.getFileName())
                .uuid(fileVO.getUuid())
                .first(fileVO.isFirst())
                .photoType(fileVO.isPhotoType())
                .profile(ProfileDTO.builder()
                        .profileId(fileVO.getProfile().getProfileId())
                        .build())
                .build();
    }

    default FileVO dto2Entity(FileDTO fileDTO) {
        return FileVO.builder()
                .fileId(fileDTO.getFileId())
                .fileName(fileDTO.getFileName())
                .uuid(fileDTO.getUuid())
                .first(fileDTO.isFirst())
                .photoType(fileDTO.isPhotoType())
                .build();
    }

    default FileVO dto2EntityProfile(FileDTO fileDTO) {
        return FileVO.builder()
                .fileId(fileDTO.getFileId())
                .fileName(fileDTO.getFileName())
                .uuid(fileDTO.getUuid())
                .first(fileDTO.isFirst())
                .photoType(fileDTO.isPhotoType())
                .profile(Profile.builder()
                        .profileId(fileDTO.getProfile().getProfileId())
                        .build())
                .build();
    }

    default FileVO dto2EntityHire(FileDTO fileDTO){
        return FileVO.builder()
                .fileId(fileDTO.getFileId())
                .fileName(fileDTO.getFileName())
                .uuid(fileDTO.getUuid())
                .first(fileDTO.isFirst())
                .photoType(fileDTO.isPhotoType())
                .hire(Hire.builder()
                        .hireId(fileDTO.getHire().getHireId())
                        .build())
                .build();
    }

}