package shop.goodcasting.api.user.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;

    @NotBlank(message = "유효하지 않은 아이디입니다.")
    private String username;

    @NotBlank(message = "유효하지 않은 비밀번호입니다.")
    @Size(min = 8, message = "Minimum password length: 8")
    private String password;

    private boolean position;
    private boolean account;
    private List<Role> roles;

    private String token;
}
