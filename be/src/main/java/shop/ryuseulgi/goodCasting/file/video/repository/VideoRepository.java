package shop.ryuseulgi.goodCasting.file.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.file.video.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
