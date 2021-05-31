package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class HireListDTO {
    private Long hireId;

    private String project;
    private String cast;
    private LocalDateTime deadline;
    private Timestamp regDate;
    private Timestamp modDate;

    private String producerAgency;

    private String fileName;
    private String fileUuid;
}