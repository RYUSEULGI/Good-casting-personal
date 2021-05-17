package shop.ryuseulgi.goodCasting.user.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {
}