package shop.ryuseulgi.goodCasting.user.actor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
    private String height;
    private String weight;
    private String agency;
    private Boolean major;
}