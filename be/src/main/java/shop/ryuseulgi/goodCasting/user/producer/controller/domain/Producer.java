package shop.ryuseulgi.goodCasting.producer.domain;

import shop.ryuseulgi.goodCasting.hire.domain.Hire;

import javax.persistence.*;

@Entity
@Table(name="producers")
public class Producer {

    @Id
    @GeneratedValue
    @Column(name="producer_id")
    private long producerId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "hire_id")
    private Hire hire;
}

