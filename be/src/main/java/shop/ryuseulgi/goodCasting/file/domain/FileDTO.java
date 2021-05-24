package shop.ryuseulgi.goodCasting.file.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;

import java.sql.Timestamp;

@ToString
@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private Long fileId;
    private String fileName;
    private String uuid;
    private boolean first;
    private boolean photoType;
    private Timestamp regDate;
    private Timestamp modDate;

    private ProfileDTO profile;
    private HireDTO hire;
}
