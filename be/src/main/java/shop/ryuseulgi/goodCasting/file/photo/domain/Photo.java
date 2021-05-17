package shop.ryuseulgi.goodCasting.file.photo.domain;

import lombok.Getter;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "photos")
public class Photo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "file_size") private String fileSize;
    @Column(name = "file_name") private String fileName;
    @Column(name = "saved_file_name") private String savedFileName;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}