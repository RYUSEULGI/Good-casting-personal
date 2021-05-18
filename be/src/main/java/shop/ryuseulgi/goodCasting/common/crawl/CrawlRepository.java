package shop.ryuseulgi.goodCasting.common.crawl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;

@Repository
public interface CrawlRepository extends JpaRepository<Actor,Long> {
}