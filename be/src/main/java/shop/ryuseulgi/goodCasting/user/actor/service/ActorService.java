package shop.ryuseulgi.goodCasting.user.actor.service;

import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    List<Actor> findAll();
    ActorDTO findById(Long actorId);
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
                .age(actorDTO.getAge())
                .email(actorDTO.getEmail())
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
                .age(actorDTO.getAge())
                .email(actorDTO.getEmail())
                .user(UserVO.builder()
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
                .age(actor.getAge())
                .email(actor.getEmail())
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
                .age(actor.getAge())
                .email(actor.getEmail())
                .user(UserDTO.builder()
                        .userId(actor.getUser().getUserId())
                        .build())
                .build();
    }
}