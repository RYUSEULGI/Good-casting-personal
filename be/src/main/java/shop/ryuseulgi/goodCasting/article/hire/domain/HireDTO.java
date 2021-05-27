package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;

import java.security.Timestamp;
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
    private String title;
    private String project;
    private String cast;    //배역
    private String filming; //촬영기간
    private String guarantee; //출연료
    private String personnel; //모집인원
    private String deadline; //공고마감일
    private String contents; //내용
    private Timestamp regDate;
    private Timestamp modDate;

    private String producerName;
    private String fileUuid;
    private String fileName;

    //join object
    private ProducerDTO producer;
    private List<FileDTO> files;
}