package shop.ryuseulgi.goodCasting.user.producer.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProducerDTO {
    private Long producerId;
    private String email;
    private String agency;
    private String phone;
    private String position;
}