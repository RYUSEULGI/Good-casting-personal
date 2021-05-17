package shop.ryuseulgi.goodCasting.file.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.file.photo.domain.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}