package shop.ryuseulgi.goodCasting.apply.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.apply.domain.*;
import shop.ryuseulgi.goodCasting.apply.repository.ApplyRepository;
import shop.ryuseulgi.goodCasting.security.exception.SecurityRuntimeException;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService{
    private final ApplyRepository applyRepo;

    @Override
    @Transactional
    public ApplyDTO apply(ApplyDTO applyDTO) {

        Long profileId = applyDTO.getProfile().getProfileId();
        Long hireId = applyDTO.getHire().getHireId();

        List<Long> applyList = applyRepo.duplicateCheck(profileId, hireId);

        log.info(applyList);

        if(applyList.size() >= 1 ) {
            throw new RuntimeException("duplicate apply");
        } else {
            applyRepo.save(dto2EntityAll(applyDTO));
        }
        return null;
    }

    @Override
    @Transactional
    public List<ApplyDTO> findAllByHireId(Long hireId) {
        return applyRepo.findAllByProfileId(hireId).stream().map(message -> {
            return entity2DtoAll(message);
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ApplyPageResultDTO<ApplyListDTO, Object[]> getApplicantList(ApplyPageRequestDTO pageRequest) {
        Page<Object[]> result;
        Function<Object[], ApplyListDTO> fn;
        result = applyRepo.applicantList(pageRequest,pageRequest
                .getPageable(Sort.by(pageRequest.getSort()).descending()));

        fn = (entity -> entity2DtoAll2((Apply) entity[0]));
        return new ApplyPageResultDTO<>(result, fn, pageRequest);
    }

    @Override
    public Long delete(Long applyId) {
        applyRepo.deleteById(applyId);
        return 1L;
    }

}