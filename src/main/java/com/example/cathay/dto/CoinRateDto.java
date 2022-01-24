package com.example.cathay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinRateDto {
    String code;
    String name;
    float rate;
    String createTime;
}
