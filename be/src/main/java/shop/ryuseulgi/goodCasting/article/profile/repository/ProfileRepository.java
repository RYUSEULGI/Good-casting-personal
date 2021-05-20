package shop.ryuseulgi.goodCasting.article.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("select p, p.actor, f from Profile p left join FileVO f on f.profile = p where p.profileId = :profileId")
    List<Object[]> getProfileAndFileAndActorByProfileId(@Param("profileId") Long profileId);

    @Query("select p, a from Profile p left join p.actor a where p.profileId = :profileId")
    Object getProfileWithActorByProfileId(@Param("profileId") Long profileId);
}