package shop.ryuseulgi.goodCasting.file.video.domain;

import lombok.Getter;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "videos")
public class Video extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "file_size") private String fileSize;
    @Column(name = "file_name") private String fileName;
    @Column(name = "saved_file_name") private String savedFileName;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}