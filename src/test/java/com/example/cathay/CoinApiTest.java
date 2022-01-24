package com.example.cathay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.cathay.dto.CoinDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.service.CoinService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoinApiTest {
    private Logger LOGGER = LoggerFactory.getLogger(CoinApiTest.class);
    @Autowired
    private CoinService coinService = new CoinService();

    @Test
    public void testGetCoin() {
        Result<CoinDto> result = coinService.getCoin("EUR");
        String expected = "歐元";
        String actual = result.getData().getName();

        LOGGER.info("testGetCoin result: {}", result);
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateCoin() {
        CoinDto coinDto = new CoinDto();
        coinDto.setCode("NTD");
        coinDto.setName("新台幣");
        Result<String> result = coinService.createCoin(coinDto);
        boolean expected = true;
        boolean actual = result.isSuccess();

        LOGGER.info("testCreateCoin result: {}", result);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateCoin() {
        CoinDto coinDto = new CoinDto();
        coinDto.setCode("USD");
        coinDto.setName("美金");
        Result<String> result = coinService.updateCoin(coinDto);
        boolean expected = true;
        boolean actual = result.isSuccess();

        LOGGER.info("testUpdateCoin result: {}", result);
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteCoin() {
        Result<String> result = coinService.deleteCoin("EUR");
        boolean expected = true;
        boolean actual = result.isSuccess();

        LOGGER.info("testGetCoin result: {}", result);
        assertEquals(expected, actual);
    }
}
