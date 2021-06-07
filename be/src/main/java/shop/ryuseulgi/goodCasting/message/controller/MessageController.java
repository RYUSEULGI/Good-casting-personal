package shop.ryuseulgi.goodCasting.message.controller;

import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.article.profile.domain.ProfileDTO;
import shop.ryuseulgi.goodCasting.message.domain.MessageActionType;
import shop.ryuseulgi.goodCasting.message.domain.MessageDTO;
import shop.ryuseulgi.goodCasting.message.service.MessageServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/messages")
public class MessageController {

    private final MessageServiceImpl service;

    @PostMapping("/send")
    public ResponseEntity<MessageDTO> send(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(service.send(messageDTO));
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<Optional<MessageDTO>> readMessage(@PathVariable Long messageId){
        return ResponseEntity.ok(service.findById(messageId));
    }

    @GetMapping("/list/{receiver}")
    public ResponseEntity<List<MessageDTO>> messageList(@PathVariable Long receiver){
        return ResponseEntity.ok(service.findAllByReceiverId(receiver));
    }

    @GetMapping("/list/{actionType}/{receiver}")
    public ResponseEntity<List<MessageDTO>> messageTypeList(@PathVariable MessageActionType actionType){
        return ResponseEntity.ok(service.findByType(actionType));
    }

    @PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(service.update(messageDTO));
    }

    @DeleteMapping("/delete/{messageId}")
    public ResponseEntity<Long> delete(@PathVariable Long messageId){
        return ResponseEntity.ok(service.deleteById(messageId));
    }

}