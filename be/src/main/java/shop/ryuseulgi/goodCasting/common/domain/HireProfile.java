package shop.ryuseulgi.goodCasting.common.domain;

import lombok.Builder;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;

import javax.persistence.*;

@Builder
@Table(name = "hire_profiles")
@Entity
public class HireProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hire_profile_id")
    private long hireProfileId;

    @ManyToOne
    @JoinColumn(name = "hire_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Hire hire;
}
