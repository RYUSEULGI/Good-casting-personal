package shop.ryuseulgi.goodCasting.file.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jcodec.api.awt.FrameGrab;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.scale.AWTUtil;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.repository.ProfileRepository;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.file.repository.FileRepository;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepo;
    private final ProfileRepository profileRepo;
    private final ActorRepository actorRepo;
    private final UserRepository userRepo;

    public void extractVideoThumbnail(File file) throws Exception {
        SeekableByteChannel byteChannel = NIOUtils.readableFileChannel(file);
        MP4Demuxer dm = new MP4Demuxer(byteChannel);
        DemuxerTrack vt = dm.getVideoTrack();

        String fileName = file.getAbsolutePath();
        fileName = fileName.substring(0, fileName.lastIndexOf(".")) +".jpg";

        File imageFile = new File(fileName);

        double frameNumber = 0d;

        frameNumber = vt.getMeta().getTotalDuration() / 5.0;

        log.info(frameNumber);

        Picture frame = FrameGrab.getNativeFrame(file, frameNumber);

        log.info(frame);

        BufferedImage img = AWTUtil.toBufferedImage(frame);

        File imgFile = new File(fileName);

        ImageIO.write(img, "jpg", imgFile);
    }

    @Transactional
    @Override
    public List<FileDTO> findFileListByProfileId(Long profileId) {
        List<FileVO> fileList = fileRepo.findFileListByProfileId(profileId);

        fileList.forEach(file -> log.info("file: " + file));

        return fileList.stream().map(entity -> {
//            log.info("file service - findAll() - entity: " + entity);
            Profile profile = entity.getProfile();
            log.info("file service - findAll() - profile Class: " + profile.getProfileId());
//            log.info("file service - findAll() - profile.regdate: " + profile.getRegDate());

            return entity2Dto(entity);
        }).collect(Collectors.toList());
    }
}