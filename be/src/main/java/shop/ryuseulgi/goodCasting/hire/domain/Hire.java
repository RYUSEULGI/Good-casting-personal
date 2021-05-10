package shop.ryuseulgi.goodCasting.hire.domain;

import shop.ryuseulgi.goodCasting.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.recommend.domain.Recommend;
import shop.ryuseulgi.goodCasting.resume.domain.Resume;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hires")
public class Hire {

    @Id
    @GeneratedValue
    @Column(name="hire_id")
    private long hireId;

    @Column(name="title")
    private String title;

    @Column(name="contents")
    private String contents;

    @OneToMany(mappedBy = "hire")
    List<Producer> producers = new ArrayList<>();

    @OneToMany(mappedBy = "hire")
    List<Recommend> recommends = new ArrayList<>();
}
