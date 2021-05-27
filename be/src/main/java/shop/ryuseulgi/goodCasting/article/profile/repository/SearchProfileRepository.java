package shop.ryuseulgi.goodCasting.article.profile.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import shop.ryuseulgi.goodCasting.common.domain.PageRequestDTO;

@Repository
public interface SearchProfileRepository {
    Page<Object[]> searchPage(PageRequestDTO pageRequest, Pageable pageable);
}
