package shop.ryuseulgi.goodCasting.user.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;

@Builder
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProducerDTO {
    private Long producerId;
    private String email;
    private String agency;
    private String phone;
    private String position;

    private UserDTO user;
}