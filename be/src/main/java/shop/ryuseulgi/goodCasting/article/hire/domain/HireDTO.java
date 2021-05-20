package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class HireDTO {
    // pk
    private Long hireId;

    /// data
    private String hireTitle;
    private String cast;    //배역
    private String filming; //촬영기간
    private String guarantee; //출연료
    private String personnel; //모집인원
    private String deadline; //공고마감일
    private String contents; //내용
    private String confidence;
    private String resemble;

    private Timestamp regDate;
    private Timestamp modDate;

    //join object
    private Producer producer;
    private ArrayList<FileDTO> files;
    private List<ProfileDTO> profiles;
}