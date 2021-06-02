package shop.ryuseulgi.goodCasting.article.profile.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.ryuseulgi.goodCasting.common.domain.PageRequestDTO;

public interface SearchProfileRepository {
    Page<Object[]> searchPage(PageRequestDTO pageRequest, Pageable pageable);
    Page<Object[]> myProfilePage(PageRequestDTO pageRequest, Pageable pageable);
}