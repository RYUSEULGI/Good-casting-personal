package shop.ryuseulgi.goodCasting.user.login.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;
import shop.ryuseulgi.goodCasting.user.login.service.UserServiceImpl;

@Log @Api(tags="users")
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;

    @PostMapping("/signup")
    @ApiOperation(value="${UserController.signup}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 username")})
    public ResponseEntity<String> signup(@ApiParam("Signup user") @RequestBody UserDTO userDTO){
        log.info("회원가입 할꺼임");
        return ResponseEntity.ok(service.signup(userDTO));
    }

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> signin(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.signin(userDTO));
    }
}