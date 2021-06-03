package shop.ryuseulgi.goodCasting.article.profile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.ryuseulgi.goodCasting.article.hire.domain.HireListDTO;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileListDTO;
import shop.ryuseulgi.goodCasting.article.profile.service.ProfileServiceImpl;
import shop.ryuseulgi.goodCasting.common.domain.PageRequestDTO;
import shop.ryuseulgi.goodCasting.common.domain.PageResultDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImpl profileService;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody ProfileDTO profileDTO) {
        System.out.println("Profile DTO: " + profileDTO);

        profileService.register(profileDTO);

        return ResponseEntity.ok(1L);
    }

    @GetMapping("/detail/{profileId}")
    public ResponseEntity<ProfileDTO> profileDetail(@PathVariable Long profileId) {
        return ResponseEntity.ok(profileService.readProfile(profileId));
    }

    @PostMapping("/list")
    public ResponseEntity<PageResultDTO<ProfileListDTO, Object[]>> profileList(@RequestBody PageRequestDTO pageRequest) {
        System.out.println("--------------------- : "+pageRequest);
        return new ResponseEntity<>(profileService.getProfileList(pageRequest), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody ProfileDTO profileDTO) {
        profileService.update(profileDTO);

        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{profileId}")
    public ResponseEntity<Long> delete(@PathVariable Long profileId) {

        profileService.deleteProfile(profileId);

        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

}