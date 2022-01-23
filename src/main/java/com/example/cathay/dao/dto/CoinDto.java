package com.example.cathay.dao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoinDto {
    String code;
    String name;
    float rate;
    String createTime;
}
