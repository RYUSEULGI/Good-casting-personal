package shop.ryuseulgi.goodCasting.message.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;

import java.sql.Timestamp;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class MessageDTO {
    private Long messageId;
    private MessageActionType messageActionType;
    private Timestamp regDate;
    private boolean readMessage;

    private UserDTO sender;
    private UserDTO receiver;
}
