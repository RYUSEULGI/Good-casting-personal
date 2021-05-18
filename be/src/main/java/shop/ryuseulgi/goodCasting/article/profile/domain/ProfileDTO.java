package shop.ryuseulgi.goodCasting.article.profile.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProfileDTO {
    private Long profileId;
    boolean privacy;
    private String contents;
    private String career;
}