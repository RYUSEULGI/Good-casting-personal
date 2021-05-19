package shop.ryuseulgi.goodCasting.article.profile.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.service.ProfileServiceImpl;

@Log
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ProfileDTO profileDTO) {
        log.info("register : 진입");
        log.info("Profile DTO: " + profileDTO);
        log.info("Profile DTO actor name: " + profileDTO.getActor());
        log.info("Profile DTO user username: " + profileDTO.getActor().getUserVO());
        service.register(profileDTO);

        return ResponseEntity.ok(1L);
    }
}