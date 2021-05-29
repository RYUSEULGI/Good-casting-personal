package shop.ryuseulgi.goodCasting.article.profile.service;

import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.common.domain.PageRequestDTO;
import shop.ryuseulgi.goodCasting.common.domain.PageResultDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileVO;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;

import java.util.ArrayList;
import java.util.List;

public interface ProfileService {
    Long register(ProfileDTO profileDTO);
    ProfileDTO readProfile(Long profileId);

    PageResultDTO<ProfileDTO, Object[]> getProfileList(PageRequestDTO requestDTO);

    default Profile dto2Entity(ProfileDTO profileDTO) {
        return Profile.builder()
                .profileId(profileDTO.getProfileId())
                .contents(profileDTO.getContents())
                .privacy(profileDTO.isPrivacy())
                .resemble(profileDTO.getResemble())
                .confidence(profileDTO.getConfidence())
                .build();
    }

    default Profile dto2EntityAll(ProfileDTO profileDTO){
        return Profile.builder()
                .profileId(profileDTO.getProfileId())
                .contents(profileDTO.getContents())
                .privacy(profileDTO.isPrivacy())
                .resemble(profileDTO.getResemble())
                .confidence(profileDTO.getConfidence())
                .actor(Actor.builder()
                        .actorId(profileDTO.getActor().getActorId())
                        .build())
                .build();
    }

    default ProfileDTO entity2Dto(Profile profile) {
        return ProfileDTO.builder()
                .profileId(profile.getProfileId())
                .contents(profile.getContents())
                .privacy(profile.isPrivacy())
                .resemble(profile.getResemble())
                .confidence(profile.getConfidence())
                .regDate(profile.getRegDate())
                .modDate(profile.getModDate())
                .build();
    }

    default ProfileDTO entity2DtoAll(Profile profile) {
        return ProfileDTO.builder()
                .profileId(profile.getProfileId())
                .contents(profile.getContents())
                .privacy(profile.isPrivacy())
                .resemble(profile.getResemble())
                .confidence(profile.getConfidence())
                .regDate(profile.getRegDate())
                .modDate(profile.getModDate())
                .actor(ActorDTO.builder()
                        .actorId(profile.getActor().getActorId())
                        .build())
                .build();
    }

    default ProfileDTO entity2DtoFiles(Profile profile, FileVO file, Actor actor) {
        return ProfileDTO.builder()
                .profileId(profile.getProfileId())
                .contents(profile.getContents())
                .privacy(profile.isPrivacy())
                .resemble(profile.getResemble())
                .confidence(profile.getConfidence())
                .regDate(profile.getRegDate())
                .modDate(profile.getModDate())
                .fileName(file.getFileName())
                .fileUuid(file.getUuid())
                .actorName(actor.getName())
                .actorAge(actor.getAge())
                .build();
    }
}