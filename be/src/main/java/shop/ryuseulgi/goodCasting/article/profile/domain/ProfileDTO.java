package shop.ryuseulgi.goodCasting.article.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireDTO;
import shop.ryuseulgi.goodCasting.file.domain.FileDTO;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;

import java.util.ArrayList;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ProfileDTO {
    // pk
    private Long profileId;

    private boolean privacy;
    private String contents;
    private String career;
    private String resemble;
    private String confidence;
    private Timestamp regDate;
    private Timestamp modDate;
    private Actor actor;

    private ArrayList<FileDTO> files;
//    private List<HireProfile> hires;
}