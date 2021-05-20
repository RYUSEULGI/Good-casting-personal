package shop.ryuseulgi.goodCasting.user.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Modifying
    @Query("update UserVO u set u.account = :account where u.id = :user_id")
    void update(@Param("user_id") Long userId, @Param("account") Boolean account);

    @Query("select u from UserVO u where u.username = :username and u.password = :password")
    UserDTO signin(@Param("username") String username, @Param("password") String password);
}
