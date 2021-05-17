package shop.ryuseulgi.goodCasting.article.hire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {
}