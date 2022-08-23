package com.crawling.item.controller;

import com.crawling.item.dto.ActionDto;
import com.crawling.item.service.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DummyGeneratorContoller {

    private final DummyService dummyService;

    @PostMapping("/dummy-generate")
    public ResponseEntity<Boolean> dummyGenerator(@RequestBody ActionDto actionDto) {

        try {
            dummyService.saveDummyDataInKafkaAndDatabase(actionDto);

            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }

}
