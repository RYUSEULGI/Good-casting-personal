package shop.ryuseulgi.goodCasting.user.actor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final UserRepository userRepository;
    private final FileRepository fileRepository;
    private final ProfileRepository profileRepository;
    private final ActorRepository actorRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public ActorDTO findById(Long actorId) {

        Optional<Actor> actor = actorRepository.findById(actorId);

        return actor.isPresent()? entity2DtoAll(actor.get()): null;
    }

    @Transactional
    @Override
    public Long delete(ActorDTO actorDTO) {
        Actor actor = dto2EntityAll(actorDTO);

        Long profileId = actorRepository.getProfileId(actor.getActorId());

        log.info("profileId : " + profileId);

        if(profileId != null){
            Profile profile = profileRepository.findById(profileId).get();
            List<FileVO> fileList = fileRepository.findFileListByProfileId(profileId);

            log.info("fileList : " + fileList);

            List<Long> fileId = new ArrayList<>();
            fileList.forEach( i -> {
                fileId.add(i.getFileId());
            });
            log.info("fileId : " + fileId);

            fileId.forEach( id -> {
                FileVO test = fileRepository.findById(id).get();
                System.out.println(test);
                fileRepository.delete(test);
            });

            profileRepository.delete(profile);
        }
        actorRepository.delete(actor);
        userRepository.accountUpdate(actor.getUser().getUserId(), false);
        actorRepository.delete(actor);

        return actorRepository.findById(actor.getActorId()).orElse(null) == null ? 1L : 0L;
    }

    @Override
    @Transactional
    public ActorDTO moreDetail(ActorDTO actorDTO) {
        Actor actor = dto2EntityAll(actorDTO);
        actorRepository.save(actor);
        return null;
    }
}