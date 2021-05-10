package shop.ryuseulgi.goodCasting.resume.domain;

import shop.ryuseulgi.goodCasting.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.recommend.domain.Recommend;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue
    @Column(name="resume_id")
    private long resumeId;

    @Column(name="career")
    private String career;

    @OneToMany(mappedBy = "resume")
    List<Actor> actors = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    List<Recommend> recommends = new ArrayList<>();
}

