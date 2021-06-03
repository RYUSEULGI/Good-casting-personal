package shop.ryuseulgi.goodCasting.apply.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.ryuseulgi.goodCasting.apply.domain.ApplyPageRequestDTO;

public interface SearchApplyRepository {
    Page<Object[]> applicantList(ApplyPageRequestDTO pageRequest, Pageable pageable);
}