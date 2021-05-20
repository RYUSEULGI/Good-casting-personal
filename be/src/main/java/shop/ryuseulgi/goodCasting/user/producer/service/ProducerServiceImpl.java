package shop.ryuseulgi.goodCasting.user.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository repo;

    @Override
    public Optional<Producer> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Producer> findAll() {
        return repo.findAll();
    }

    @Override
    public Long delete(Producer producer) {
        repo.delete(producer);
        return repo.findById(producer.getProducerId()).orElse(null) == null ? 1L : 0L;
    }
}
