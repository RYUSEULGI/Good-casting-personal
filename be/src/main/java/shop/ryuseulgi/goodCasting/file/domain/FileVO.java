package shop.ryuseulgi.goodCasting.file.domain;

import lombok.*;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

@ToString(exclude = {"profile", "hire"})
@Getter
@Table(name = "files")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileVO extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long fileId;

    @Column private String uuid;
    @Column private boolean first;
    @Column(name = "file_name") private String fileName;
    @Column(name = "photo_type") private boolean photoType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hire_id")
    private Hire hire;
}

