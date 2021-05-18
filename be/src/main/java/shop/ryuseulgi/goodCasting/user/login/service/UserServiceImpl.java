package shop.ryuseulgi.goodCasting.user.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.security.domain.SecurityProvider;
import shop.ryuseulgi.goodCasting.security.exception.SecurityRuntimeException;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.login.domain.Role;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.repository.ProducerRepository;

import java.util.ArrayList;
import java.util.List;

@Log
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final ActorRepository actorRepo;
    private final ProducerRepository producerRepo;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;

    @Override
    public String signup(UserDTO userDTO) {

        UserVO userVO = dto2Entity(userDTO);

        if(!userRepo.existsByUsername(userVO.getUsername())){
            userVO.changePassword(passwordEncoder.encode(userVO.getPassword()));

            List<Role> actorList = new ArrayList<>();
            List<Role> producerList = new ArrayList<>();
            Boolean position = userVO.getPosition();
            Actor actor = new Actor();
            Producer producer = new Producer();

            if(position){
                actorList.add(Role.USER);
                userVO.changeRoles(actorList);
                userRepo.save(userVO);
                actor.changeUserVO(userVO);
                actorRepo.save(actor);
            } else {
                producerList.add(Role.USER);
                userVO.changeRoles(producerList);
                userRepo.save(userVO);
                producer.changeUserVO(userVO);
                producerRepo.save(producer);
            }
            return provider.createToken(userVO.getUsername(), userVO.getRoles());
        }else{
            throw new SecurityRuntimeException("중복된 username", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDTO signin(UserDTO userDTO) {
        try{
            UserVO userVO = dto2Entity(userDTO);

            String token = (passwordEncoder.matches(userVO.getPassword(), userRepo.findByUsername(userVO.getUsername()).get().getPassword()))
                    ?provider.createToken(userVO.getUsername(), userRepo.findByUsername(userVO.getUsername()).get().getRoles())
                    : "Wrong password";

            userDTO.setToken(token);
            return userDTO;
        }catch(Exception e){
            throw new SecurityRuntimeException("유효하지 않은 아이디 / 비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}