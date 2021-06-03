package shop.ryuseulgi.goodCasting.article.hire.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.hire.domain.*;
import shop.ryuseulgi.goodCasting.article.hire.repository.HireRepository;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.file.service.FileService;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.domain.ProducerDTO;
import shop.ryuseulgi.goodCasting.user.producer.service.ProducerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class HireServiceImpl implements HireService {
    private final HireRepository hireRepo;
    private final FileRepository fileRepo;
    private final FileService fileService;
    private final ProducerService producerService;

    @Transactional
    @Override
    public Long register(HireDTO hireDTO) {
        HireDTO finalHireDto = entity2DtoAll(hireRepo.save(dto2EntityAll(hireDTO)));

        List<FileDTO> files = hireDTO.getFiles();

        return saveFile(finalHireDto, files);

    }
    @Transactional
    @Override
    public HireDTO readHire(Long hireId) {
        List<Object[]> hireAndFileAndProducer = hireRepo.getHireAndFileAndProducerByHireId(hireId);

        Hire hire = (Hire) hireAndFileAndProducer.get(0)[0];
        Producer producer = hire.getProducer();

        HireDTO hireDTO = entity2Dto(hire);

        ProducerDTO producerDTO = producerService.entity2Dto(producer);

        List<FileDTO> fileList = new ArrayList<>();

        hireAndFileAndProducer.forEach(objects -> {
            fileList.add(fileService.entity2Dto((FileVO)objects[2]));
        });

        hireDTO.setProducer(producerDTO);
        hireDTO.setFiles(fileList);

        return hireDTO;
    }

    @Override
    public HirePageResultDTO<HireListDTO, Object[]> getHireList(HirePageRequestDTO pageRequest) {

        Page<Object[]> result;
        Function<Object[], HireListDTO> fn;
        if (pageRequest.getProducerId() == null) {
            result = hireRepo.searchPage(pageRequest,
                    pageRequest.getPageable(Sort.by(pageRequest.getSort()).descending()));

            fn = (entity -> entity2DtoFiles((Hire) entity[0],
                    (Producer) entity[1]));
        } else {
            result = hireRepo.myHirePage(pageRequest,
                    pageRequest.getPageable(Sort.by(pageRequest.getSort()).descending()));

            fn = (entity -> entity2DtoMy((Hire) entity[0],
                    (Producer) entity[1], (FileVO) entity[2]));
        }

        return new HirePageResultDTO<>(result, fn ,pageRequest);
    }

    @Transactional
    public Long update(HireDTO hireDTO) {
        Long hireId = hireDTO.getHireId();

        hireRepo.save(dto2EntityAll(hireDTO));
        fileRepo.deleteByHireId(hireId);

        List<FileDTO> files = hireDTO.getFiles();

        return saveFile(hireDTO, files);
    }

    @Transactional
    public void deleteHire(Long hireId) {
        fileRepo.deleteByHireId(hireId);

        hireRepo.deleteById(hireId);
    }

    public Long saveFile(HireDTO hireDTO, List<FileDTO> files) {
        if(files != null && files.size() > 0) {
            files.forEach(fileDTO -> {
                fileDTO.setHire(hireDTO);
                FileVO file = fileService.dto2EntityHire(fileDTO);
                fileRepo.save(file);
            });
            return 1L;
        }
        return 0L;
    }
}