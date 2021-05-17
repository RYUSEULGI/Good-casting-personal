package shop.ryuseulgi.goodCasting.file.photo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.ryuseulgi.goodCasting.file.photo.service.PhotoServiceImpl;

@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoServiceImpl service;
}