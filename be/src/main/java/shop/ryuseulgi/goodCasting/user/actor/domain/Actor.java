package shop.ryuseulgi.goodCasting.user.actor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;

import lombok.Getter;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

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
    @Column private String height;
    @Column private String weight;
    @Column private String agency;
    @Column private Boolean major;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserVO userVO;

    public void changeActorId(Long actorId) {
        this.actorId = actorId;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void changePhone(String phone) {
        this.phone = phone;
    }

    public void changeHeight(String height) {
        this.height = height;
    }

    public void changeWeight(String weight) {
        this.weight = weight;
    }

    public void changeAgency(String agency) {
        this.agency = agency;
    }

    public void changeMajor(Boolean major) {
        this.major = major;
    }

    public void changeUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}
