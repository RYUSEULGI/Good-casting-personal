package shop.ryuseulgi.goodCasting.recommend.domain;

import shop.ryuseulgi.goodCasting.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.resume.domain.Resume;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="recommends")
public class Recommend {

    @Id
    @GeneratedValue
    @Column(name="recommend_id")
    private long recommendId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "hire_id")
    private Hire hire;
}
