package com.example.cathay;

import com.example.cathay.dto.CoinRateDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.service.CoinRateService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CurrentPriceRepositoryTest {
    private Logger LOGGER = LoggerFactory.getLogger(CoinApiTest.class);
    @Autowired
    private CoinRateService coinRateService = new CoinRateService();

    @Test
    public void testGetCoinRate() {
        Result<CoinRateDto> result = coinRateService.getCoinRate("EUR");
        String expected = "歐元";
        String actual = result.getData().getName();

        LOGGER.info("testGetCoinRate result: {}", result);
        assertEquals(expected, actual);
    }
}
