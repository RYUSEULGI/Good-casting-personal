package shop.ryuseulgi.goodCasting.message.service;

import shop.ryuseulgi.goodCasting.message.domain.Message;
import shop.ryuseulgi.goodCasting.message.domain.MessageActionType;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    MessageDTO send(MessageDTO messageDTO);
    List<MessageDTO> findByType(MessageActionType actionType);

    default Message dto2Entity(MessageDTO messageDTO){
        return Message.builder()
                .messageId(messageDTO.getMessageId())
                .readMessage(messageDTO.isReadMessage())
                .messageActionType(messageDTO.getMessageActionType())
                .build();
    }

    default Message dto2EntityAll(MessageDTO messageDTO){
        return Message.builder()
                .messageId(messageDTO.getMessageId())
                .readMessage(messageDTO.isReadMessage())
                .messageActionType(messageDTO.getMessageActionType())
                .sender(UserVO.builder()
                        .userId(messageDTO.getSender().getUserId())
                        .build())
                .receiver(UserVO.builder()
                        .userId(messageDTO.getReceiver().getUserId())
                        .build())
                .build();
    }

    default MessageDTO entity2Dto(Message message){
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .readMessage(message.isReadMessage())
                .messageActionType(message.getMessageActionType())
                .build();
    }

    default MessageDTO entity2DtoAll(Message message){
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .readMessage(message.isReadMessage())
                .messageActionType(message.getMessageActionType())
                .sender(UserDTO.builder()
                        .userId(message.getSender().getUserId())
                        .build())
                .receiver(UserDTO.builder()
                        .userId(message.getSender().getUserId())
                        .build())
                .build();
    }
}
