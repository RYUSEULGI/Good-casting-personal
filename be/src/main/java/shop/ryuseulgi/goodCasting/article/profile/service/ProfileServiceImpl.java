package shop.ryuseulgi.goodCasting.article.profile.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;

import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.file.service.FileService;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.actor.service.ActorService;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepo;
    private final FileRepository fileRepo;
    private final FileService fileService;
    private final ActorService actorService;

    @Transactional
    @Override
    public Long register(ProfileDTO profileDTO) {
        Profile profile = dto2Entity(profileDTO);
        System.out.println("service - register - profile: " + profile);

        Profile finalProfile = profileRepo.save(profile);

        List<FileDTO> files = profileDTO.getFiles();

        if(files != null && files.size() > 0) {

            files.forEach(fileDTO -> {
                fileDTO.setProfile(finalProfile);
                FileVO file = fileService.dto2Entity(fileDTO);

                fileRepo.save(file);
            });
        }

        return null;
    }

    @Transactional
    @Override
    public ProfileDTO readProfile(Long profileId) {
        System.out.println("getProfileWithFileByProfileId() entry");

        List<Object[]> profileAndFileAndActor = profileRepo.getProfileAndFileAndActorByProfileId(2L);

        Profile profile = (Profile) profileAndFileAndActor.get(0)[0];
        Actor actor = profile.getActor();
        System.out.println("actor: " + actor);

        ProfileDTO profileDTO = entity2Dto(profile);
        System.out.println("profileDTO: " + profileDTO);

        ActorDTO actorDTO = actorService.entity2Dto(actor);
        System.out.println("actorDTO: " + actorDTO);

        List<FileDTO> fileList = new ArrayList<>();

        profileAndFileAndActor.forEach(arr -> {
            fileList.add(fileService.entity2Dto((FileVO)arr[2]));
        });

        profileDTO.setActor(actor);
        profileDTO.setFiles(fileList);

        System.out.println("profile dto: " + profileDTO);

        return profileDTO;
    }

}