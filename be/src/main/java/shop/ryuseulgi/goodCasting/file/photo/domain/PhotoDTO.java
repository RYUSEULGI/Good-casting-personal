package shop.ryuseulgi.goodCasting.file.photo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;

@Data
@Component
public class PhotoDTO {
    private Long photoId;
    private String fileSize;
    private String fileName;
    private String savedFileName;
    private Profile profile;
}