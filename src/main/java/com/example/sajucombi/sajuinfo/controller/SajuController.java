package com.example.sajucombi.sajuinfo.controller;

import com.example.sajucombi.sajuinfo.service.SajuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Validated
@RequiredArgsConstructor
@RestController
public class SajuController {
    private SajuService sajuService;

//    @GetMapping("/sajuhome")
//    public

//    @PostMapping("/sajuresult")


}
