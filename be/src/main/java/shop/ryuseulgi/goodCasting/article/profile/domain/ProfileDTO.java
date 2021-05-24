package shop.ryuseulgi.goodCasting.article.profile.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.common.domain.HireProfile;
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
    private String career;
    private String resemble;
    private Double confidence;
    private Timestamp regDate;
    private Timestamp modDate;

    private String actorName;
    private String fileUuid;
    private String fileName;

    private ActorDTO actor;
    private List<FileDTO> files;
}