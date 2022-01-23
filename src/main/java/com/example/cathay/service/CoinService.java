package com.example.cathay.service;

import com.example.cathay.dao.dto.CoinDto;
import com.example.cathay.entity.Coin;
import com.example.cathay.repository.ICoinMappingRepository;
import com.example.cathay.repository.coin.CoinMappingRepository;
import com.example.cathay.repository.coin.CurrentPriceRepository;
import com.example.cathay.response.CoinDeskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Optional;

@Service
public class CoinService {
    @Autowired
    ICoinMappingRepository coinMappingRepository;
    @Autowired
    CurrentPriceRepository currentPriceRepository;

    public CoinDto getCoin(String code) {
        CoinDto result = new CoinDto();
        CoinDeskResponse coinDeskResponse = currentPriceRepository.getCoin();
        Optional<Coin> coinResponse = coinMappingRepository.findById(1);

        Iterable<Coin> coinAllResponse = coinMappingRepository.findAll();

        result.setCode(code);
        result.setName(coinResponse.get().getName());
//        result.setRate(coinDeskResponse.get);
//        result.setCreateTime(coinResponse.getCreateTime());
        return result;
    }
}
