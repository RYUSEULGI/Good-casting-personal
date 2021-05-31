package shop.ryuseulgi.goodCasting.user.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.ryuseulgi.goodCasting.security.domain.SecurityProvider;
import shop.ryuseulgi.goodCasting.security.exception.SecurityRuntimeException;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.login.domain.Role;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.login.repository.UserRepository;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.repository.ProducerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final ActorRepository actorRepo;
    private final ProducerRepository producerRepo;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;

    @Override
    public String signup(UserDTO userDTO) {
        if(!userRepo.existsByUsername(userDTO.getUsername())){
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            List<Role> actorList = new ArrayList<>();
            List<Role> producerList = new ArrayList<>();
            Boolean position = userDTO.isPosition();
            Actor actor = new Actor();
            Producer producer = new Producer();

            if(position){
                actorList.add(Role.USER);
                userDTO.setRoles(actorList);

                UserVO userVO = dto2Entity(userDTO);

                userRepo.save(userVO);
                actor.changeUserVO(userVO);
                actorRepo.save(actor);
            } else {
                producerList.add(Role.USER);
                userDTO.setRoles(producerList);

                UserVO userVO = dto2Entity(userDTO);

                userRepo.save(userVO);
                producer.changeUserVO(userVO);
                producerRepo.save(producer);
            }
            return provider.createToken(userDTO.getUsername(), userDTO.getRoles());
        }else{
            throw new SecurityRuntimeException("중복된 username", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<Object> signin(UserDTO userDTO) {

        List<Object> infoList = new ArrayList<>();
        if(userRepo.checkAccount(userDTO.getUsername())){
            try{
                UserVO userVO = dto2Entity(userDTO);

                String token = (passwordEncoder.matches(userVO.getPassword(), userRepo.findByUsername(userVO.getUsername()).get().getPassword()))
                        ?provider.createToken(userVO.getUsername(), userRepo.findByUsername(userVO.getUsername()).get().getRoles())
                        : "Wrong password";

                userDTO.setUserId(userRepo.findByUsername(userVO.getUsername()).get().getUserId());
                userDTO.setAccount(userRepo.findByUsername(userVO.getUsername()).get().isAccount());
                userDTO.setPosition(userRepo.findByUsername(userVO.getUsername()).get().isPosition());

                userDTO.setToken(token);

                ActorDTO actorDTO = new ActorDTO();
                Long actorId = actorRepo.getActorIdFromUserId(userDTO.getUserId());

                actorDTO.setActorId(actorId);
                infoList.add(userDTO);
                infoList.add(actorDTO);

                log.info("infoList :" + infoList);
                return infoList;
            }catch(Exception e){
                throw new SecurityRuntimeException("유효하지 않은 아이디 / 비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } else{
            throw new SecurityRuntimeException("탈퇴한 회원입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<UserVO> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDTO findById(Long id) {
        UserDTO userDTO = entity2Dto(userRepo.findById(id).get());
        return userDTO;
    }

    @Override
    public Optional<UserVO> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}