package shop.ryuseulgi.goodCasting.user.login.service;

import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String signup(UserDTO userDTO);
    UserDTO signin(UserDTO userDTO);
    List<UserVO> findAll();
    UserDTO findById(Long id);
    Optional<UserVO> findByUsername(String username);

    default UserVO dto2Entity(UserDTO userDTO) {
        return UserVO.builder()
                .userId(userDTO.getUserId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .position(userDTO.getPosition())
                .account(userDTO.getAccount())
                .roles(userDTO.getRoles())
                .build();
    }
    default UserDTO entity2Dto(UserVO userVO) {
        return UserDTO.builder()
                .userId(userVO.getUserId())
                .username(userVO.getUsername())
                .password(userVO.getPassword())
                .position(userVO.getPosition())
                .account(userVO.getAccount())
                .roles(userVO.getRoles())
                .build();
    }
}
