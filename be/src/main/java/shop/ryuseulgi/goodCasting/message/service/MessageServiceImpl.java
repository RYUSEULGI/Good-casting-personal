package shop.ryuseulgi.goodCasting.message.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.message.domain.Message;
import shop.ryuseulgi.goodCasting.message.domain.MessageActionType;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.message.repository.MessageRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Log
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepo;

    @Transactional
    public List<MessageDTO> findAllById(Iterable<Long> receiver) {
        List<Message> messages = messageRepo.findAllById(receiver);
        List<MessageDTO> messageDTOList = new ArrayList<>();

        messages.forEach(message -> {
            messageDTOList.add(entity2DtoAll(message));
        });

        return messageDTOList;
    }

    @Override
    public MessageDTO send(MessageDTO messageDTO) {
        Message message = dto2EntityAll(messageDTO);
        messageRepo.save(message);
        return null;
    }

    @Transactional
    public Long deleteById(Long messageId) {
        messageRepo.deleteById(messageId);
        return 1L;
    }

    @Override
    public List<MessageDTO> findByType(MessageActionType actionType) {
        List<Message> messages = messageRepo.findByActionType(actionType);

        List<MessageDTO> messageDTOList = new ArrayList<>();

        messages.forEach(message -> {
            messageDTOList.add(entity2DtoAll(message));
        });

        return messageDTOList;
    }
}
