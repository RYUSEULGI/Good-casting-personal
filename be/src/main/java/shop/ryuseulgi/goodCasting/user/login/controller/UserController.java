package shop.ryuseulgi.goodCasting.user.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.user.login.service.UserServiceImpl;

@Log
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;
    private final ModelMapper modelMapper;

}