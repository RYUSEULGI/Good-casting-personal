package shop.ryuseulgi.goodCasting.file.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;

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
    private Timestamp regDate;
    private Timestamp modDate;

    private Profile profile;
}
