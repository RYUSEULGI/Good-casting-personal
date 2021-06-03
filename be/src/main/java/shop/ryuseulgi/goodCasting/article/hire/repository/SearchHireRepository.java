package shop.ryuseulgi.goodCasting.article.hire.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.ryuseulgi.goodCasting.article.hire.domain.HirePageRequestDTO;

public interface SearchHireRepository {
    Page<Object[]> searchPage(HirePageRequestDTO pageRequest, Pageable pageable);
    Page<Object[]> myHirePage(HirePageRequestDTO pageRequest, Pageable pageable);
}