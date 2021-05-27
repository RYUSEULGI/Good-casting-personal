package shop.ryuseulgi.goodCasting.user.actor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.actor.service.ActorServiceImpl;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {

    private final ActorServiceImpl service;
    private final ActorRepository repo;

    @GetMapping("/list")
    public ResponseEntity<List<Actor>> actorList(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/myPage/{actorId}")
    public ResponseEntity<ActorDTO> myPage(@PathVariable Long actorId){
        return ResponseEntity.ok(service.findById(actorId));
    }

    @PostMapping("/info")
    public ResponseEntity<ActorDTO> moreDetail(@RequestBody ActorDTO actorDTO){
        return ResponseEntity.ok(service.moreDetail(actorDTO));
    }

    @DeleteMapping("/delete/{actorId}")
    public ResponseEntity<Long> delete(@RequestBody ActorDTO actorDTO){
        return ResponseEntity.ok(service.delete(actorDTO));
    }
}
