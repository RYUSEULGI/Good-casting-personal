package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.*;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString(exclude = {"producer"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "hires")
public class Hire extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hire_id") private Long hireId;

    @Column private String title;
    @Column private String project;
    @Column(columnDefinition = "TEXT") private String contents;
    @Column private String cast;
    @Column private LocalDate filming;
    @Column private Integer guarantee;
    @Column private String personnel;
    @Column private LocalDateTime deadline;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id")
    private Producer producer;

}