package com.tomo.webservice.controller;

import com.tomo.webservice.domain.SampleRepository;
import com.tomo.webservice.domain.SampleSaveRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterfly
 * Date : 2019.03.20
 */

@RestController
@AllArgsConstructor
public class SampleController {

    private SampleRepository repository;

    @PostMapping("/save/sample")
    public void saveSample(@RequestBody SampleSaveRequestDTO dto) {
        repository.save(dto.toEntity());
    }
}
