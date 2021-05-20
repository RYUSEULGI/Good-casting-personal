package shop.ryuseulgi.goodCasting.article.hire.service;

import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;

import java.util.List;
import java.util.Optional;

public interface HireService {
    Long register(HireDTO hireDTO);

    default Hire dto2Entity(HireDTO hireDTO) {
        Hire entity = Hire.builder()
                .hireId(hireDTO.getHireId())
                .title(hireDTO.getHireTitle())
                .contents(hireDTO.getContents())
                .cast(hireDTO.getCast())
                .filming(hireDTO.getFilming())
                .guarantee(hireDTO.getGuarantee())
                .personnel(hireDTO.getPersonnel())
                .deadline(hireDTO.getDeadline())
                .producer(hireDTO.getProducer())
                .build();
        return entity;
    }

    default Producer dto2EntityProducer(ProducerDTO producerDTO) {
        Producer producer = Producer.builder()
                .producerId(producerDTO.getProducerId())
                .email(producerDTO.getEmail())
                .agency(producerDTO.getAgency())
                .phone(producerDTO.getPhone())
                .position(producerDTO.getPosition())
                .build();
        return producer;
    }

    default FileVO dto2EntityFile(FileDTO fileDTO) {
        FileVO file = FileVO.builder()
                .fileId(fileDTO.getFileId())
                .fileName(fileDTO.getFileName())
                .uuid(fileDTO.getUuid())
                .first(fileDTO.isFirst())
                .build();
        return file;
    }

}