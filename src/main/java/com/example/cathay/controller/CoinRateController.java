package com.example.cathay.controller;

import com.example.cathay.dto.CoinRateDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.service.CoinRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinRateController {
    @Autowired
    private CoinRateService coinRateService;
    @GetMapping("coin-rate")
    public Result<CoinRateDto> getCoin(@RequestParam("code") String code) {
        Result<CoinRateDto> result = coinRateService.getCoinRate(code);
        return result;
    }
}
