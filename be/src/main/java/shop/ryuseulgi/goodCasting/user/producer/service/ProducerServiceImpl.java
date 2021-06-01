package shop.ryuseulgi.goodCasting.user.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.repository.HireRepository;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;
import shop.ryuseulgi.goodCasting.user.producer.repository.ProducerRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final UserRepository userRepo;
    private final ProducerRepository producerRepo;
    private final FileRepository fileRepo;
    private final HireRepository hireRepo;

    @Override
    public List<Producer> findAll() {
        return producerRepo.findAll();
    }

    @Override
    public ProducerDTO findById(Long producerId) {
        Optional<Producer> producer = producerRepo.findById(producerId);

        return producer.map(this::entity2DtoAll).orElse(null);
    }

    @Override
    @Transactional
    public Long delete(ProducerDTO producerDTO) {
        Producer producer = dto2EntityAll(producerDTO);

        Long hireId = producerRepo.getHireId(producer.getProducerId());

        log.info("hireId : " + hireId);

        if(hireId != null){
            Hire hire = hireRepo.findById(hireId).get();
            List<FileVO> fileList = fileRepo.findFileListByHireId(hireId);

            log.info("fileList : " + fileList);

            List<Long> fileId = new ArrayList<>();
            fileList.forEach( i -> fileId.add(i.getFileId()));
            log.info("fileId : " + fileId);

            fileId.forEach( id -> {
                FileVO test = fileRepo.findById(id).get();
                System.out.println(test);
                fileRepo.delete(test);
            });

            hireRepo.delete(hire);
        }
        userRepo.accountUpdate(producer.getUser().getUserId(), false);
        producerRepo.delete(producer);

        return producerRepo.findById(producer.getProducerId()).orElse(null) == null ? 1L : 0L;
    }

    @Override
    @Transactional
    public ProducerDTO moreDetail(ProducerDTO producerDTO) {
//        String passwordUp =  passwordEncoder.encode(producerDTO.getUser().getPassword());
//        userRepository.passwordUpdate(producerDTO.getUser().getUserId(), passwordUp);
        Producer producer = dto2EntityAll(producerDTO);
        producerRepo.save(producer);
        return null;
    }
}