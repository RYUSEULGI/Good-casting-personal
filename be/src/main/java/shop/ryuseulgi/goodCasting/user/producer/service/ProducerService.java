package shop.ryuseulgi.goodCasting.user.producer.service;

import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;

import java.util.List;
import java.util.Optional;

public interface ProducerService {
    List<Producer> findAll();
    Optional<Producer> findById(Long producerId);
    Long delete(Producer producer);
}
