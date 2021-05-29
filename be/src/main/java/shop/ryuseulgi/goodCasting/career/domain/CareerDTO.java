package shop.ryuseulgi.goodCasting.career.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;

@ToString
@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CareerDTO {
    private Long careerId;
    private Integer year;
    private String gerne;
    private String title;
    private String contents;

    private ProfileDTO profile;
}
