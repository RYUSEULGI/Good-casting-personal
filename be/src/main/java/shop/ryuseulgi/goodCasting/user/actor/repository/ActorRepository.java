package shop.ryuseulgi.goodCasting.user.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("select p.profileId from Actor a left join Profile p on a.actorId = p.actor.actorId where a.actorId = :actor_id")
    Long getProfileId (@Param("actor_id") Long actorId);

    @Query("select a.actorId from Actor a where a.user.userId = :user_id")
    Long getActorIdFromUserId(@Param("user_id") Long userId);

    @Query("select a.name from Actor a where a.user.userId = :user_id")
    String getActorNameFromUserId(@Param("user_id") Long userId);

}
