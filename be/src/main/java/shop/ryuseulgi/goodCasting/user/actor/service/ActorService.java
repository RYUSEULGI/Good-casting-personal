package shop.ryuseulgi.goodCasting.user.actor.service;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    List<Actor> findAll();
    Optional<Actor> findById(Long actorId);
    Long delete(ActorDTO actorDTO);

    ActorDTO moreDetail(ActorDTO actorDTO);

    default Actor dto2Entity(ActorDTO actorDTO){
        return Actor.builder()
                .actorId(actorDTO.getActorId())
                .height(actorDTO.getHeight())
                .phone(actorDTO.getPhone())
                .weight(actorDTO.getWeight())
                .birthday(actorDTO.getBirthday())
                .major(actorDTO.isMajor())
                .agency(actorDTO.getAgency())
                .gender(actorDTO.getGender())
                .name(actorDTO.getName())
                .build();
    }

    default Actor dto2EntityAll(ActorDTO actorDTO){
        return Actor.builder()
                .actorId(actorDTO.getActorId())
                .height(actorDTO.getHeight())
                .phone(actorDTO.getPhone())
                .weight(actorDTO.getWeight())
                .birthday(actorDTO.getBirthday())
                .major(actorDTO.isMajor())
                .agency(actorDTO.getAgency())
                .gender(actorDTO.getGender())
                .name(actorDTO.getName())
                .userVO(UserVO.builder()
                        .userId(actorDTO.getUser().getUserId())
                        .build())
                .build();
    }

    default ActorDTO entity2Dto(Actor actor){
        return ActorDTO.builder()
                .actorId(actor.getActorId())
                .name(actor.getName())
                .height(actor.getHeight())
                .phone(actor.getPhone())
                .weight(actor.getWeight())
                .birthday(actor.getBirthday())
                .major(actor.isMajor())
                .gender(actor.getGender())
                .agency(actor.getAgency())
                .build();
    }

    default ActorDTO entity2DtoAll(Actor actor){
        return ActorDTO.builder()
                .actorId(actor.getActorId())
                .name(actor.getName())
                .height(actor.getHeight())
                .phone(actor.getPhone())
                .weight(actor.getWeight())
                .birthday(actor.getBirthday())
                .major(actor.isMajor())
                .gender(actor.getGender())
                .agency(actor.getAgency())
                .user(UserDTO.builder()
                        .userId(actor.getUserVO().getUserId())
                        .build())
                .build();
    }
}