package shop.ryuseulgi.goodCasting.article.hire.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.ryuseulgi.goodCasting.common.domain.PageRequestDTO;

public interface SearchHireRepository {
    Page<Object[]> searchPage(PageRequestDTO pageRequest, Pageable pageable);
}