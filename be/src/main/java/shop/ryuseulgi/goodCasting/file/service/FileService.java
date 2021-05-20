package shop.ryuseulgi.goodCasting.file.service;

import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;

import java.io.File;
import java.util.List;

public interface FileService {
    void extractVideoThumbnail(File file) throws Exception;

    List<FileDTO> findFileListByProfileId(Long profileId);

    default FileDTO entity2Dto(FileVO entity) {
        return FileDTO.builder()
                .fileId(entity.getFileId())
                .fileName(entity.getFileName())
                .uuid(entity.getUuid())
                .first(entity.isFirst())
                .profile(entity.getProfile())
                .build();
    }

    default FileVO dto2Entity(FileDTO dto) {
        return FileVO.builder()
                .fileId(dto.getFileId())
                .fileName(dto.getFileName())
                .uuid(dto.getUuid())
                .first(dto.isFirst())
                .profile(dto.getProfile())
                .build();
    }


}
