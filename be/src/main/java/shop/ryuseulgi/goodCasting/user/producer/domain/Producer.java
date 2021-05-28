package shop.ryuseulgi.goodCasting.user.producer.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import javax.persistence.*;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="producers")
public class Producer extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producer_id") private Long producerId;

    @Column private String name;
    @Column private String email;
    @Column private String agency;
    @Column private String phone;
    @Column private String position;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserVO userVO;

    public void changeUserVO(UserVO userVO) {
        this.userVO = userVO;
    }
}

