package shop.ryuseulgi.goodCasting.article.profile.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.Profile;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.service.ProfileServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ProfileDTO profileDTO) {
        System.out.println("Profile DTO: " + profileDTO);

        service.register(profileDTO);

        return ResponseEntity.ok(1L);
    }

    @GetMapping("/profile-detail/{profileId}")
    public ResponseEntity<ProfileDTO> profileDetail(@PathVariable Long profileId) {
        return ResponseEntity.ok(service.readProfile(profileId));
    }

    @GetMapping("/profile-list")
    public ResponseEntity<List<ProfileDTO>> profileList() {

        return ResponseEntity.of(null);
    }
}