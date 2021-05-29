package shop.ryuseulgi.goodCasting.career.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.career.domain.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}
