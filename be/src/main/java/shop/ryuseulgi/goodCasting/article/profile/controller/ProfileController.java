package shop.ryuseulgi.goodCasting.article.profile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.service.ProfileServiceImpl;
import shop.ryuseulgi.goodCasting.common.domain.PageRequestDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ProfileDTO profileDTO) {
        service.register(profileDTO);
        return ResponseEntity.ok(1L);
    }

    @GetMapping("/detail/{profileId}")
    public ResponseEntity<ProfileDTO> profileDetail(@PathVariable Long profileId) {
        return ResponseEntity.ok(service.readProfile(profileId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProfileDTO>> profileList(@RequestBody PageRequestDTO pageRequest) {
        return new ResponseEntity<>(service.getProfileList(pageRequest).getDtoList(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody ProfileDTO profileDTO) {
        service.update(profileDTO);
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Long> delete(@PathVariable Long profileId) {
        service.deleteProfile(profileId);
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }
}