package shop.ryuseulgi.goodCasting.message.service;

import shop.ryuseulgi.goodCasting.message.domain.Message;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    Long send(MessageDTO messageDTO);

    default Message dto2Entity(MessageDTO messageDTO){
        return Message.builder()
                .messageId(messageDTO.getMessageId())
                .read(messageDTO.isRead())
                .sender(messageDTO.getSender())
                .receiver(messageDTO.getReceiver())
                .regDate(messageDTO.getRegDate())
                .actionType(messageDTO.getActionType())
                .build();
    }

    default Message dto2EntityAll(MessageDTO messageDTO){
        return Message.builder()
                .messageId(messageDTO.getMessageId())
                .read(messageDTO.isRead())
                .sender(messageDTO.getSender())
                .receiver(messageDTO.getReceiver())
                .regDate(messageDTO.getRegDate())
                .actionType(messageDTO.getActionType())
                .actor(Actor.builder()
                        .actorId(messageDTO.getActor().getActorId())
                        .build())
                .producer(Producer.builder()
                        .producerId(messageDTO.getProducer().getProducerId())
                        .build())
                .build();
    }

    default MessageDTO entity2Dto(Message message){
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .read(message.isRead())
                .sender(message.getSender())
                .receiver(message.getReceiver())
                .regDate(message.getRegDate())
                .actionType(message.getActionType())
                .build();
    }

    default MessageDTO entity2DtoAll(Message message){
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .read(message.isRead())
                .sender(message.getSender())
                .receiver(message.getReceiver())
                .regDate(message.getRegDate())
                .actionType(message.getActionType())
                .actor(ActorDTO.builder()
                        .actorId(message.getActor().getActorId())
                        .build())
                .producer(ProducerDTO.builder()
                        .producerId(message.getProducer().getProducerId())
                        .build())
                .build();
    }
}
