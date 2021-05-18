package shop.ryuseulgi.goodCasting.article.hire.service;

import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;

import java.util.List;
import java.util.Optional;

public interface HireService {
    Long save(Hire hire);
    List<Hire> findAll();
    Optional<Hire> findById(Long id);
    Long delete(Hire id);

    default Hire dto2Entity(HireDTO hireDTO){
        Hire hire = Hire.builder()
                .hireId(hireDTO.getHireId())
                .title(hireDTO.getHireTitle())
                .cast(hireDTO.getCast())
                .filming(hireDTO.getFilming())
                .guarantee(hireDTO.getGuarantee())
                .personnel(hireDTO.getPersonnel())
                .deadline(hireDTO.getDeadline())
                .contents(hireDTO.getContents())
                .build();
        return hire;
    }

    default HireDTO entity2Dto(Hire hire){
        HireDTO hireDTO = HireDTO.builder()
                .hireId(hire.getHireId())
                .hireTitle(hire.getTitle())
                .cast(hire.getCast())
                .filming(hire.getFilming())
                .guarantee(hire.getGuarantee())
                .personnel(hire.getPersonnel())
                .deadline(hire.getDeadline())
                .contents(hire.getContents())
                .build();
        return hireDTO;
    }
}
