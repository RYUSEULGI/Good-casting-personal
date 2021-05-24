package shop.ryuseulgi.goodCasting.message.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class MessageDTO {
    private Long messageId;
    private Long messageKind;
    private String message;

    private ProducerDTO producer;
    private ActorDTO actor;
}
