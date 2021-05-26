package shop.ryuseulgi.goodCasting.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "hire_profiles")
@NoArgsConstructor
@AllArgsConstructor
public class HireProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hire_profile_id")
    private long hireProfileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hire_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Hire hire;
}
