package shop.ryuseulgi.goodCasting.user.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

}