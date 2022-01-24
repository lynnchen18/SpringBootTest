package com.example.cathay.service;

import com.example.cathay.dto.CoinDto;
import com.example.cathay.dto.CoinRateDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.entity.Coin;
import com.example.cathay.repository.ICoinMappingRepository;
import com.example.cathay.repository.coin.CurrentPriceRepository;
import com.example.cathay.response.CoinDeskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class CoinRateService {
    @Autowired
    ICoinMappingRepository coinMappingRepository;
    @Autowired
    CurrentPriceRepository currentPriceRepository;

    public Result<CoinRateDto> getCoinRate(String code) {
        CoinRateDto coinRateDto = new CoinRateDto();
        Result<CoinRateDto> result = new Result(null);

        try {
            CoinDeskResponse coinDeskResponse = currentPriceRepository.getCoin();
            Optional<Coin> coinResponse = coinMappingRepository.findById(code);
            SimpleDateFormat simpleDateFormatFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            coinRateDto.setCode(code);
            coinRateDto.setName(coinResponse.get().getName());
            coinRateDto.setRate(coinDeskResponse.getBpi().get(code).getRate_float());
            coinRateDto.setCreateTime(simpleDateFormatFormat.format(coinResponse.get().getCreateTime()));

            result.setData(coinRateDto);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
