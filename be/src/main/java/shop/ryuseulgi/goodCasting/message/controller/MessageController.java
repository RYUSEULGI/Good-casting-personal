package shop.ryuseulgi.goodCasting.message.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.message.domain.Message;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.message.service.MessageServiceImpl;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;

import java.util.List;

@Log
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/messages")
public class MessageController {

    private final MessageServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<List<Message>> messageList(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/send")
    public ResponseEntity<Long> send(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageDTO.getMessageId());
    }
}