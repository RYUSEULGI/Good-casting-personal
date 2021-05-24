package shop.ryuseulgi.goodCasting.message.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.message.domain.Message;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.message.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Long send(MessageDTO messageDTO) {
        Message message = dto2EntityAll(messageDTO);
        messageRepository.save(message);
        return 1L;
    }
}
