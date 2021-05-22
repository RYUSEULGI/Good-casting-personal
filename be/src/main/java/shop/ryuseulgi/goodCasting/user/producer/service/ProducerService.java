package shop.ryuseulgi.goodCasting.user.producer.service;

import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;

import java.util.List;
import java.util.Optional;

public interface ProducerService {
    List<Producer> findAll();
    Optional<Producer> findById(Long producerId);
    Long delete(ProducerDTO producerDTO);
    ProducerDTO moreDetail(ProducerDTO producerDTO);

    default Producer dto2Entity(ProducerDTO producerDTO){
        return Producer.builder()
                .producerId(producerDTO.getProducerId())
                .agency(producerDTO.getAgency())
                .email(producerDTO.getEmail())
                .phone(producerDTO.getPhone())
                .position(producerDTO.getPosition())
                .build();
    }

    default Producer dto2EntityAll(ProducerDTO producerDTO){

        return Producer.builder()
                .producerId(producerDTO.getProducerId())
                .agency(producerDTO.getAgency())
                .email(producerDTO.getEmail())
                .phone(producerDTO.getPhone())
                .position(producerDTO.getPosition())
                .userVO(UserVO.builder().userId(producerDTO.getUser().getUserId()).build())
                .build();
    }

    default ProducerDTO entity2Dto(Producer producer){
        return ProducerDTO.builder()
                .producerId(producer.getProducerId())
                .agency(producer.getAgency())
                .email(producer.getEmail())
                .phone(producer.getPhone())
                .position(producer.getPosition())
                .build();
    }

    default ProducerDTO entity2DtoAll(Producer producer){
        return ProducerDTO.builder()
                .producerId(producer.getProducerId())
                .agency(producer.getAgency())
                .email(producer.getEmail())
                .phone(producer.getPhone())
                .position(producer.getPosition())
                .user(UserDTO.builder().userId(producer.getUserVO().getUserId()).build())
                .build();
    }
}
