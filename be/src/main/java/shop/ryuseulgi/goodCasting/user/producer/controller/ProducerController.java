package shop.ryuseulgi.goodCasting.user.producer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;
import shop.ryuseulgi.goodCasting.user.producer.repository.ProducerRepository;
import shop.ryuseulgi.goodCasting.user.producer.service.ProducerServiceImpl;

import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/producers")
public class ProducerController {
    private final ProducerServiceImpl service;
    private final ProducerRepository repo;

    @GetMapping("/list")
    public ResponseEntity<List<Producer>> producerList(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<Producer>> detail(@RequestBody Producer producer){
        return ResponseEntity.ok(service.findById(producer.getProducerId()));
    }

    @PutMapping("/update")
    public ResponseEntity<Producer> update(@RequestBody Producer producer){
        return ResponseEntity.ok(repo.save(producer));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody Producer producer){
        return ResponseEntity.ok(service.delete(producer));
    }

}
