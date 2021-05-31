package shop.ryuseulgi.goodCasting.user.actor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;

import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final UserRepository userRepo;
    private final FileRepository fileRepo;
    private final ProfileRepository profileRepo;
    private final ActorRepository actorRepo;

    @Override
    public List<Actor> findAll() {
        return actorRepo.findAll();
    }

    @Override
    public ActorDTO findById(Long actorId) {

        Optional<Actor> actor = actorRepo.findById(actorId);

        return actor.isPresent()? entity2DtoAll(actor.get()): null;
    }

    @Transactional
    @Override
    public Long delete(ActorDTO actorDTO) {
        Actor actor = dto2EntityAll(actorDTO);

        Long profileId = actorRepo.getProfileId(actor.getActorId());

        log.info("profileId : " + profileId);

        if(profileId != null){
            Profile profile = profileRepo.findById(profileId).get();
            List<FileVO> fileList = fileRepo.findFileListByProfileId(profileId);

            log.info("fileList : " + fileList);

            List<Long> fileId = new ArrayList<>();
            fileList.forEach( i -> {
                fileId.add(i.getFileId());
            });
            log.info("fileId : " + fileId);

            fileId.forEach( id -> {
                FileVO test = fileRepo.findById(id).get();
                System.out.println(test);
                fileRepo.delete(test);
            });

            profileRepo.delete(profile);
        }
        actorRepo.delete(actor);
        userRepo.accountUpdate(actor.getUser().getUserId(), false);
        actorRepo.delete(actor);

        return actorRepo.findById(actor.getActorId()).orElse(null) == null ? 1L : 0L;
    }

    @Override
    @Transactional
    public ActorDTO moreDetail(ActorDTO actorDTO) {
        Actor actor = dto2EntityAll(actorDTO);
        log.info("actorDTO : " + actorDTO.getMajor());
        log.info("actor : " + actor.getMajor());
        actorRepo.save(actor);
        log.info("actor : " + actor.getMajor());
        return null;
    }
}