package shop.ryuseulgi.goodCasting.article.profile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.service.ProfileServiceImpl;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ProfileDTO profileDTO) {
        System.out.println("Profile DTO: " + profileDTO);
        System.out.println("Profile DTO actor name: " + profileDTO.getActor());
        System.out.println("Profile DTO user username: " + profileDTO.getActor().getUserVO());

        service.register(profileDTO);

        return ResponseEntity.ok(1L);
    }
}