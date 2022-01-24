package com.example.cathay.service;

import com.example.cathay.dto.CoinDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.entity.Coin;
import com.example.cathay.repository.ICoinMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class CoinService {
    @Autowired
    ICoinMappingRepository coinMappingRepository;

    public Result<CoinDto> getCoin(String code) {
        CoinDto coinDto = new CoinDto();
        Result<CoinDto> result = new Result(null);

        try {
            Optional<Coin> coinResponse = coinMappingRepository.findById(code);
            SimpleDateFormat simpleDateFormatFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            coinDto.setCode(code);
            coinDto.setName(coinResponse.get().getName());
            coinDto.setCreateTime(simpleDateFormatFormat.format(coinResponse.get().getCreateTime()));

            result.setData(coinDto);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result<String> createCoin(CoinDto coinDto) {
        Result<String> result = new Result(null);

        try {
            Optional<Coin> coinResponse = coinMappingRepository.findById(coinDto.getCode());
            if (coinResponse.get() == null) {
                Coin coin = new Coin();
                coin.setCode(coinDto.getCode());
                coin.setName(coinDto.getName());
                coin.setCreateTime(new Date());
                coinMappingRepository.save(coin);

                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Result<String> updateCoin(CoinDto coinDto) {
        Result<String> result = new Result(null);

        try {
            Optional<Coin> coinResponse = coinMappingRepository.findById(coinDto.getCode());
            if (coinResponse.get() != null) {
                Coin coin = new Coin();
                coin.setCode(coinDto.getCode());
                coin.setName(coinDto.getName());
                coin.setCreateTime(new Date());
                coinMappingRepository.save(coin);

                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Result<String> deleteCoin(String code) {
        Result<String> result = new Result(null);

        try {
            coinMappingRepository.deleteById(code);

            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        coinMappingRepository.deleteById(code);
        return result;
    }
}
