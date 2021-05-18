package shop.ryuseulgi.goodCasting.user.login.service;

import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

public interface UserService {
    String signup(UserDTO userDTO);
    UserDTO signin(UserDTO userDTO);

    default UserVO dto2Entity(UserDTO userDTO) {
        return UserVO.builder()
                .userId(userDTO.getUserId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
    }
    default UserDTO entity2Dto(UserVO userVO) {
        return UserDTO.builder()
                .userId(userVO.getUserId())
                .username(userVO.getUsername())
                .password(userVO.getPassword())
                .build();
    }
}
