package shop.ryuseulgi.goodCasting.article.hire.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;
import shop.ryuseulgi.goodCasting.article.hire.repository.HireRepository;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;
import shop.ryuseulgi.goodCasting.user.producer.repository.ProducerRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class HireServiceImpl implements HireService {
    private final HireRepository hireRepo;
    private final FileRepository fileRepo;
    private final ProducerRepository producerRepo;
    private final UserRepository userRepo;

    @Transactional
    @Override
    public Long register(HireDTO hireDTO) {
        Hire hire = dto2Entity(hireDTO);
//        System.out.println("service - register - hire: " +hire);
//        userRepo.save(hire.getProducer().getUserVO());
//
//        producerRepo.save(hire.getProducer());
//
//        Hire finalHire = hireRepo.save(hire);
//
//        ArrayList<FileDTO> files = hireDTO.getFiles();
//
//        if(files != null && files.size() > 0) {
//
//            files.forEach(fileDTO -> {
//                fileDTO.setHire(finalHire);
//                FileVO file = dto2EntityFile(fileDTO);
//
//                fileRepo.save(file);
//            });
//        }
        return null;
    }
}
