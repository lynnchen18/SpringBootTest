package com.example.cathay.controller;

import com.example.cathay.dao.dto.CoinDto;
import com.example.cathay.dao.dto.common.Result;
import com.example.cathay.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController {
    @Autowired
    private CoinService coinService;

    @GetMapping("coin")
    public Result<CoinDto> getCoin(@RequestParam("code") String code) {
        Result<CoinDto> result = coinService.getCoin(code);
        return result;
    }

    @DeleteMapping ("coin")
    public Result<String> deleteCoin(@RequestParam("code") String code) {
        Result<String> result = coinService.deleteCoin(code);
        return result;
    }
}
