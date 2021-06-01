package shop.ryuseulgi.goodCasting.user.actor.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

@ToString
@Builder
@Getter
@Entity
@Table(name = "actors")
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;

    @Column private String name;
    @Column private String gender;
    @Column private String birthday;
    @Column private String phone;
    @Column private Integer height;
    @Column private Integer weight;
    @Column private String agency;
    @Column private boolean major;
    @Column private String email;
    @Column private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserVO user;

    public void changeUserVO(UserVO userVO) {
        this.user = userVO;
    }
}