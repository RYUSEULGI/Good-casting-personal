package shop.ryuseulgi.goodCasting.article.profile.domain;

import lombok.*;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;
import shop.ryuseulgi.goodCasting.common.domain.HireProfile;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"actor", "hires"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "profiles")
public class Profile extends BaseEntity {
    // pk
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    // column
    @Column private String title;
    @Column private boolean privacy;
    @Column private String contents;
    @Column private String career;
    @Column private String resemble;
    @Column private String confidence;

    // join column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Builder.Default
    @OneToMany(mappedBy = "profile")
    private List<HireProfile> hires = new ArrayList<>();

}