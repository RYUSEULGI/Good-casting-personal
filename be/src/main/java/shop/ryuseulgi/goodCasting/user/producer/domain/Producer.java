package shop.ryuseulgi.goodCasting.user.producer.domain;


import lombok.Getter;
import shop.ryuseulgi.goodCasting.article.hire.domain.Hire;

import javax.persistence.*;

@Getter
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

