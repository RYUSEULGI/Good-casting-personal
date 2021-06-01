package shop.ryuseulgi.goodCasting.article.profile.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.career.domain.CareerDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;

import java.sql.Timestamp;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ProfileDTO {
    // pk
    private Long profileId;

    private boolean privacy;
    private String contents;
    private String resemble;
    private Double confidence;
    private String actorName;
    private Integer actorAge;

    private Timestamp regDate;
    private Timestamp modDate;

    private ActorDTO actor;

    private List<FileDTO> files;
    private List<CareerDTO> careers;
}
