package shop.ryuseulgi.goodCasting.file.photo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.file.photo.repository.PhotoRepository;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository repo;
}