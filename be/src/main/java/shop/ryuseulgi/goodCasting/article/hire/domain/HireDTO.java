package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.*;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class HireDTO {
    private Long hireId;

    private String title;
    private String project;
    private String contents;
    private String cast;
    private LocalDate filming;
    private Integer guarantee;
    private String personnel;
    private LocalDateTime deadline;

    private ProducerDTO producer;
    private List<FileDTO> files;
}