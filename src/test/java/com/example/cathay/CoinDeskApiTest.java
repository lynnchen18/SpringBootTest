package com.example.cathay;

import com.example.cathay.dto.CoinDto;
import com.example.cathay.dto.common.Result;
import com.example.cathay.repository.coin.CurrentPriceRepository;
import com.example.cathay.response.CoinDeskResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoinDeskApiTest {
    private Logger LOGGER = LoggerFactory.getLogger(CoinApiTest.class);
    @Autowired
    private CurrentPriceRepository currentPriceRepository;

    @Test
    public void testCoinDeskResponse() {
        CoinDeskResponse result = currentPriceRepository.getCoin();
        String expected = "Bitcoin";
        String actual = result.getChartName();

        LOGGER.info("testCoinDeskResponse result: {}", result);
        assertEquals(expected, actual);
    }
}
