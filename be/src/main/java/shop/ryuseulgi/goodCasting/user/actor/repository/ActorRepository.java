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
    @Modifying
    @Query("update UserVO u set u.account = :account where u.id = :user_id")
    void accountUpdate(@Param("user_id") Long userId, @Param("account") boolean account);

    @Modifying
    @Query("update UserVO u set u.password = :password where u.id = :user_id")
    void passwordUpdate(@Param("user_id") Long userId, @Param("password") String password);

    @Query("select p.profileId from Actor a left join Profile p on a.actorId = p.actor.actorId where a.actorId = :actor_id")
    Long getProfileId (@Param("actor_id") Long actorId);


}
