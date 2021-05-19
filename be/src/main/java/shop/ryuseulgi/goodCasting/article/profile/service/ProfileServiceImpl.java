package shop.ryuseulgi.goodCasting.article.profile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;
import shop.ryuseulgi.goodCasting.file.photo.domain.Photo;
import shop.ryuseulgi.goodCasting.file.photo.domain.PhotoDTO;
import shop.ryuseulgi.goodCasting.file.photo.repository.PhotoRepository;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepo;
    private final PhotoRepository photoRepo;
    private final ActorRepository actorRepo;
    private final UserRepository userRepo;

    @Transactional
    @Override
    public Long register(ProfileDTO profileDTO) {
        Profile profile = dto2Entity(profileDTO);
        System.out.println("service - register - profile: " + profile);

        Profile finalProfile = profileRepo.save(profile);

        ArrayList<PhotoDTO> photos = profileDTO.getPhotos();

        if(photos != null && photos.size() > 0) {
            photos.forEach(photoDTO -> {
                photoDTO.setProfile(finalProfile);
                Photo photo = dto2EntityPhoto(photoDTO);
                photoRepo.save(photo);
            });
        }

        return null;
    }
}