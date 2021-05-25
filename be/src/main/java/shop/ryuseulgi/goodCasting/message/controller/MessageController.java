package shop.ryuseulgi.goodCasting.message.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.message.domain.Message;
import shop.ryuseulgi.goodCasting.message.domain.MessageActionType;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.message.service.MessageServiceImpl;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/messages")
public class MessageController {

    private final MessageServiceImpl service;

    @GetMapping("/list/{receiver}")
    public ResponseEntity<List<MessageDTO>> messageList(@PathVariable Iterable<Long> receiver){
        log.info("receiver : " + receiver);
        return ResponseEntity.ok(service.findAllById(receiver));
    }

    @GetMapping("/list/{actionType}/{receiver}")
    public ResponseEntity<List<MessageDTO>> messageTypeList(@PathVariable MessageActionType actionType, @PathVariable Long receiver){
        return ResponseEntity.ok(service.findByType(actionType));
    }

    @PostMapping("/send")
    public ResponseEntity<MessageDTO> send(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(service.send(messageDTO));
    }

    @DeleteMapping("/delete/{messageId}")
    public ResponseEntity<Long> delete(@PathVariable Long messageId){
        return ResponseEntity.ok(service.deleteById(messageId));
    }

}