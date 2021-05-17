package shop.ryuseulgi.goodCasting.actor.domain;

import shop.ryuseulgi.goodCasting.hire.domain.Hire;
import shop.ryuseulgi.goodCasting.resume.domain.Resume;

import javax.persistence.*;

@Entity
@Table(name="actors")
public class Actor {

    @Id
    @GeneratedValue
    @Column(name="actor_id")
    private long actorId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="birthday")
    private String birthday;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="height")
    private long height;

    @Column(name="weight")
    private long weight;

    @Column(name="agency")
    private String agency;

    @Column(name="major")
    private boolean major;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

