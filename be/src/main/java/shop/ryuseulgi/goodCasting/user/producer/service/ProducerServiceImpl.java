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
    private final UserRepository userRepository;
    private final ProducerRepository producerRepository;
    private final FileRepository fileRepository;
    private final PasswordEncoder passwordEncoder;
    private final HireRepository hireRepository;

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public ProducerDTO findById(Long producerId) {
        Optional<Producer> producer = producerRepository.findById(producerId);

        return producer.isPresent()? entity2DtoAll(producer.get()): null;
    }

    @Override
    @Transactional
    public Long delete(ProducerDTO producerDTO) {
        Producer producer = dto2EntityAll(producerDTO);

        Long hireId = producerRepository.getHireId(producer.getProducerId());

        log.info("hireId : " + hireId);

        if(hireId != null){
            Hire hire = hireRepository.findById(hireId).get();
            List<FileVO> fileList = fileRepository.findFileListByHireId(hireId);

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

            hireRepository.delete(hire);
        }
        userRepository.accountUpdate(producer.getUserVO().getUserId(), false);
        producerRepository.delete(producer);

        return producerRepository.findById(producer.getProducerId()).orElse(null) == null ? 1L : 0L;
    }

    @Override
    @Transactional
    public ProducerDTO moreDetail(ProducerDTO producerDTO) {
        String passwordUp =  passwordEncoder.encode(producerDTO.getUser().getPassword());
        System.out.println("있니?" + producerDTO.getUser().getUserId());
        userRepository.passwordUpdate(producerDTO.getUser().getUserId(), passwordUp);

        Producer producer = dto2EntityAll(producerDTO);
        producerRepository.save(producer);
        return null;
    }
}