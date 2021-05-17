package shop.ryuseulgi.goodCasting.user.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") private Long userId;
    @Column(unique = true, nullable = false) private String username;
    @Size(min = 8, message = "Minimum password length: 8")
    @Column(nullable = false) private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}
