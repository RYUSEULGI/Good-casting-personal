package shop.ryuseulgi.goodCasting.career.domain;

import lombok.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

@ToString(exclude = {"profile"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "careers")
public class Career extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id") private Long careerId;

    @Column private Integer year;
    @Column private String genre;
    @Column private String title;
    @Column private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;
}