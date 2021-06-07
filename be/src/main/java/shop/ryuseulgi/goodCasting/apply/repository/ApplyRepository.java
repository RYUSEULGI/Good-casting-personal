package shop.ryuseulgi.goodCasting.apply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.apply.domain.Apply;
import shop.ryuseulgi.goodCasting.message.domain.Message;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long>, SearchApplyRepository {


    @Query("select a from Apply a where a.profile.profileId = :profileId" )
    List<Apply> findAllByProfileId(Long profileId);

    @Query("select a.applyId from Apply a where a.profile.profileId = :profileId and a.hire.hireId = :hireId" )
    List<Long> duplicateCheck(Long profileId, Long hireId);

    @Query("select a.profile.actor.actorId  from Apply a  inner join Producer on a.hire.producer.producerId = :producerId" )
    List<Apply> findAllByProducerId(Long producerId);

}
