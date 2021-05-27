package shop.ryuseulgi.goodCasting.user.actor.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;

import java.sql.Timestamp;

@ToString
@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private Long actorId;
    private String name;
    private String gender;
    private String birthday;
    private String phone;
    private Integer height;
    private Integer weight;
    private String agency;
    private boolean major;
    private String email;
    private Integer age;
    private Timestamp regDate;
    private Timestamp modDate;

    private UserDTO user;
}