package shop.ryuseulgi.goodCasting.file.photo.domain;

import lombok.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

@ToString
@Getter
@Table(name = "photos")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Photo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id")
    private Long photoId;

    private String uuid;

    private boolean first;

    @Column(name = "file_name") private String fileName;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}