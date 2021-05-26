package shop.ryuseulgi.goodCasting.user.actor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.user.actor.domain.Actor;
import shop.ryuseulgi.goodCasting.user.actor.domain.ActorDTO;
import shop.ryuseulgi.goodCasting.user.actor.repository.ActorRepository;
import shop.ryuseulgi.goodCasting.user.actor.service.ActorServiceImpl;

import java.util.List;
import java.util.Optional;

@Log
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

    @GetMapping("/myPage/{id}")
    public ResponseEntity<Optional<Actor>> myPage(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
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
