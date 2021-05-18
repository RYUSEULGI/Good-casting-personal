package shop.ryuseulgi.goodCasting.article.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}