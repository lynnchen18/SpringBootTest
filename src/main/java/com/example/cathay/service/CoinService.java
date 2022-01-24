package com.example.cathay.service;

import com.example.cathay.dao.dto.CoinDto;
import com.example.cathay.dao.dto.common.Result;
import com.example.cathay.entity.Coin;
import com.example.cathay.repository.ICoinMappingRepository;
import com.example.cathay.repository.coin.CoinMappingRepository;
import com.example.cathay.repository.coin.CurrentPriceRepository;
import com.example.cathay.response.CoinDeskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class CoinService {
    @Autowired
    ICoinMappingRepository coinMappingRepository;
    @Autowired
    CurrentPriceRepository currentPriceRepository;

    public Result<CoinDto> getCoin(String code) {
        CoinDto coinDto = new CoinDto();
        Result<CoinDto> result = new Result(coinDto);
        CoinDeskResponse coinDeskResponse = currentPriceRepository.getCoin();
        Optional<Coin> coinResponse = coinMappingRepository.findById(code);
        SimpleDateFormat simpleDateFormatFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        coinDto.setCode(code);
        coinDto.setName(coinResponse.get().getName());
//        coinDto.setRate(coinDeskResponse.get);
        coinDto.setCreateTime(simpleDateFormatFormat.format(coinResponse.get().getCreateTime()));
        return result;
    }

    public Result<String> createCoin(CoinDto coinDto) {
        Result<String> result = new Result(null);

        Optional<Coin> coinResponse = coinMappingRepository.findById(coinDto.getCode());
        if (coinResponse.get() == null) {
            Coin coin = new Coin();
            coin.setCode(coinDto.getCode());
            coin.setName(coinDto.getName());
            coin.setCreateTime(new Date());
            coinMappingRepository.save(coin);
        }
        return result;
    }

    public Result<String> updateCoin(CoinDto coinDto) {
        Result<String> result = new Result(null);

        Optional<Coin> coinResponse = coinMappingRepository.findById(coinDto.getCode());
        if (coinResponse.get() != null) {
            Coin coin = new Coin();
            coin.setCode(coinDto.getCode());
            coin.setName(coinDto.getName());
            coin.setCreateTime(new Date());

            result.setSuccess(true);
        }
        return result;
    }

    public Result<String> deleteCoin(String code) {
        Result<String> result = new Result(null);
        coinMappingRepository.deleteById(code);
        return result;
    }
}
