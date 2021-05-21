package shop.ryuseulgi.goodCasting.user.actor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.actor.service.ActorServiceImpl;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class ActorServiceImplTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActorServiceImpl actorService;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private FileRepository fileRepository;

    @Test
    public void insertTests() {
        UserVO user = UserVO.builder()
                .userId(1405L)
                .username("111")
                .password("111")
                .account(true)
                .build();
        userRepository.save(user);

        Actor actor = Actor.builder()
                .userVO(user)
                .actorId(1350L)
                .build();
        actorRepository.save(actor);

        Profile profile = Profile.builder()
                .actor(actor)
                .career("커리어")
                .contents("콘텐츠")
                .build();
        profileRepository.save(profile);

        IntStream.rangeClosed(1,3).forEach(i -> {
            FileVO fileVO = FileVO.builder()
                    .fileName("test" + i +".jpg")
                    .uuid(UUID.randomUUID().toString())
                    .profile(profile)
                    .build();
            fileRepository.save(fileVO);
        });
    }

    @Test
    public void actorDeleteTest() {

        List<Object[]> result = profileRepository.getProfileAndFileAndActorByProfileId(5L);
        System.out.println("--------------------------------------------------");

        Profile p = (Profile) result.get(0)[0];
        System.out.println("-------------------" + p.getClass());

        Actor a = p.getActor();
        System.out.println("aaaaaaaaaaaaaaaaa: " + a);

        ArrayList<FileDTO> fileList = new ArrayList<>();

        for (Object[] arr : result) {
            FileVO f = (FileVO) arr[2];

            System.out.println("file: " + arr[2]);
            System.out.println("---------------------------------");
            fileRepository.delete(f);
        }

        profileRepository.delete(p);

//        actorRepository.update(a.getUserVO().getUserId(), false);
        actorRepository.delete(a);
    }
}
