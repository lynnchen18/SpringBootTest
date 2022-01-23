package com.example.cathay.repository;

import com.example.cathay.response.CoinDeskResponse;

public interface ICurrentPriceRepository {
    CoinDeskResponse getCoin();
}
