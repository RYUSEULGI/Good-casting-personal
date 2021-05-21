package shop.ryuseulgi.goodCasting.user.actor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.file.service.FileServiceImpl;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;

import javax.transaction.Transactional;
import java.io.File;
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
    public Optional<Actor> findById(Long actorId) {
        return actorRepository.findById(actorId);
    }

    @Transactional
    @Override
    public Long delete(ActorDTO actorDTO) {
        Actor actor = dto2EntityAll(actorDTO);
        Actor test = actorRepository.getProfileId(actorDTO.getActorId());
        log.info("profileID : " + test);

//        List<File> fileList = fileRepository.findFileListByProfileId();
//
//        profileRepository.delete();
//        actorRepository.accountUpdate(actor.getUserVO().getUserId(), false);
//        actorRepository.delete(actor);

        return actorRepository.findById(actor.getActorId()).orElse(null) == null ? 1L : 0L;
    }

    @Override
    @Transactional
    public ActorDTO moreDetail(ActorDTO actorDTO) {
        String passwordUp =  passwordEncoder.encode(actorDTO.getUser().getPassword());
        actorRepository.passwordUpdate(actorDTO.getUser().getUserId(),passwordUp);

        Actor actor = dto2EntityAll(actorDTO);
        actorRepository.save(actor);
        return null;
    }
}