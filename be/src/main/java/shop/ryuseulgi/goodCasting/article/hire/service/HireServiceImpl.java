package shop.ryuseulgi.goodCasting.article.hire.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.repository.HireRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HireServiceImpl implements HireService {
    private final HireRepository repo;


    @Override
    public Long save(Hire hire) {
        return null;
    }

    @Override
    public List<Hire> findAll() {
        return null;
    }

    @Override
    public Optional<Hire> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long delete(Hire id) {
        return null;
    }
}
