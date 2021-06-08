package shop.ryuseulgi.goodCasting.apply.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ryuseulgi.goodCasting.apply.domain.ApplyDTO;
import shop.ryuseulgi.goodCasting.apply.domain.ApplyListDTO;
import shop.ryuseulgi.goodCasting.apply.domain.ApplyPageRequestDTO;
import shop.ryuseulgi.goodCasting.apply.domain.ApplyPageResultDTO;
import shop.ryuseulgi.goodCasting.apply.service.ApplyServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/applies")
public class ApplyController {

    private final ApplyServiceImpl applyService;

    @PostMapping("/doApply")
    public ResponseEntity<ApplyDTO> doApply(@RequestBody ApplyDTO applyDTO){
        return ResponseEntity.ok(applyService.apply(applyDTO));
    }

    @PostMapping("/list")
    public ResponseEntity<ApplyPageResultDTO<ApplyListDTO,Object[]>> applicantList(@RequestBody ApplyPageRequestDTO pageRequest){
        return new ResponseEntity<>(applyService.getApplicantList(pageRequest), HttpStatus.OK);
    }

    @PostMapping("/applylist")
    public ResponseEntity<ApplyPageResultDTO<ApplyListDTO,Object[]>> applyList(@RequestBody ApplyPageRequestDTO pageRequest){
        return new ResponseEntity<>(applyService.getApplyList(pageRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{applyId}")
    public ResponseEntity<Long> delete(@PathVariable Long applyId) {
        applyService.deleteApply(applyId);
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }
}