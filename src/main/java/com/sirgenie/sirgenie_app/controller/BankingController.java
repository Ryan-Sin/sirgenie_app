package com.sirgenie.sirgenie_app.controller;

import com.sirgenie.sirgenie_app.service.BankingService;
import com.sirgenie.sirgenie_app.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController
@RequestMapping("/api")
public class BankingController {

    @Autowired
    private BankingService mainService;

    /**
     * @author Ryan
     * @description 인터넷 뱅킹 모든 정보 조회
     *
     * @path /api/all
     */
    @GetMapping(value = "/all")
    public ResponseEntity<Response> getAll() {

        Response response = mainService.getAll();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}
