package shop.ryuseulgi.goodCasting.article.profile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository repo;
//    private final Photo photo;

//    public void a() {
//        photo.getProfile().getContents();
//    }
}