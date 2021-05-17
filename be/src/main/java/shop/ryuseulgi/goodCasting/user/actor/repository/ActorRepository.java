package shop.ryuseulgi.goodCasting.user.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
