package shop.ryuseulgi.goodCasting.apply.service;

import shop.ryuseulgi.goodCasting.apply.domain.Apply;
import shop.ryuseulgi.goodCasting.apply.domain.ApplyDTO;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;

import java.util.List;

public interface ApplyService {
    ApplyDTO apply(ApplyDTO applyDTO);
    List<ApplyDTO> findAllByHireId(Long hireId);

    default Apply dto2Entity(ApplyDTO applyDTO){
        return Apply.builder()
                .applyId(applyDTO.getApplyId())
                .applyStatus(applyDTO.getApplyStatus())
                .build();
    }

    default Apply dto2EntityAll(ApplyDTO applyDTO){
        return Apply.builder()
                .applyId(applyDTO.getApplyId())
                .applyStatus(applyDTO.getApplyStatus())
                .hire(Hire.builder()
                        .hireId(applyDTO.getHire().getHireId())
                        .build())
                .profile(Profile.builder()
                        .profileId(applyDTO.getProfile().getProfileId())
                        .build())
                .build();
    }

    default ApplyDTO entity2Dto(Apply apply){
        return ApplyDTO.builder()
                .applyId(apply.getApplyId())
                .applyStatus(apply.getApplyStatus())
                .build();
    }

    default ApplyDTO entity2DtoAll(Apply apply){
        return ApplyDTO.builder()
                .applyId(apply.getApplyId())
                .applyStatus(apply.getApplyStatus())
                .hire(HireDTO.builder()
                        .hireId(apply.getHire().getHireId())
                        .build())
                .profile(ProfileDTO.builder()
                        .profileId(apply.getProfile().getProfileId())
                        .actorName(apply.getProfile().getActor().getName())
                        .build())
                .build();
    }
}
