package shop.ryuseulgi.goodCasting.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.message.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
