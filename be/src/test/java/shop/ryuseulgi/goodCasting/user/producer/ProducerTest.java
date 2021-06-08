package shop.ryuseulgi.goodCasting.user.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import shop.goodcasting.api.user.login.domain.Role;
import shop.goodcasting.api.user.login.domain.UserVO;
import shop.goodcasting.api.user.login.repository.UserRepository;
import shop.goodcasting.api.user.producer.domain.Producer;
import shop.goodcasting.api.user.producer.repository.ProducerRepository;

import java.util.ArrayList;
import java.util.stream.IntStream;

@SpringBootTest
public class ProducerTest {
    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertProducerDummies(){

        IntStream.rangeClosed(2366, 2410).forEach(i -> {
            UserVO userVO = UserVO.builder()
                    .username("user" + i)
                    .password(passwordEncoder.encode("1111"))
                    .position(false)
                    .account(true)
                    .roles(new ArrayList<Role>())
                    .build();

            userVO.addRoles(Role.USER);
            userRepository.save(userVO);

            Producer producer = Producer.builder()
                    .email("producer" + i + "@daum.net")
                    .agency("소속사" + i)
                    .phone("02-" + i)
                    .position("사원")
                    .userVO(userVO)
                    .build();
            producerRepository.save(producer);
        });
    }
}
