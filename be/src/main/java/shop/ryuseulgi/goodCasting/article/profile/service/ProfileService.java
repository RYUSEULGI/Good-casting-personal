package shop.ryuseulgi.goodCasting.article.profile.service;

import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.file.photo.domain.Photo;
import shop.ryuseulgi.goodCasting.file.photo.domain.PhotoDTO;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;

public interface ProfileService {
    Long register(ProfileDTO profileDTO);

    default Profile dto2Entity(ProfileDTO profileDTO) {

        Profile entity = Profile.builder()
                .profileId(profileDTO.getProfileId())
                .career(profileDTO.getCareer())
                .contents(profileDTO.getContents())
                .privacy(profileDTO.isPrivacy())
                .actor(profileDTO.getActor())
                .build();
        return entity;
    }

    default Actor dto2EntityActor(ActorDTO actorDTO) {
        Actor actor = Actor.builder()
                .actorId(actorDTO.getActorId())
                .height(actorDTO.getHeight())
                .phone(actorDTO.getPhone())
                .weight(actorDTO.getWeight())
                .birthday(actorDTO.getBirthday())
                .major(actorDTO.getMajor())
                .agency(actorDTO.getAgency())
                .build();
        return actor;
    }

    default Photo dto2EntityPhoto(PhotoDTO photoDTO) {
        Photo photo = Photo.builder()
                .photoId(photoDTO.getPhotoId())
                .fileName(photoDTO.getFileName())
                .uuid(photoDTO.getUuid())
                .first(photoDTO.isFirst())
                .profile(photoDTO.getProfile())
                .build();
        return photo;
    }
}