package com.example.cathay.controller;

import com.example.cathay.dto.CoinDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoinController {
    @Autowired
    private CoinService coinService;

    @GetMapping("coin")
    public Result<CoinDto> getCoin(@RequestParam("code") String code) {
        Result<CoinDto> result = coinService.getCoin(code);
        return result;
    }

    @PostMapping("coin/create")
    public Result<String> createCoin(@RequestBody CoinDto coinDto) {
        Result<String> result = coinService.createCoin(coinDto);
        return result;
    }

    @PostMapping("coin/update")
    public Result<String> updateCoin(@RequestBody CoinDto coinDto) {
        Result<String> result = coinService.updateCoin(coinDto);
        return result;
    }

    @DeleteMapping ("coin")
    public Result<String> deleteCoin(@RequestParam("code") String code) {
        Result<String> result = coinService.deleteCoin(code);
        return result;
    }
}
