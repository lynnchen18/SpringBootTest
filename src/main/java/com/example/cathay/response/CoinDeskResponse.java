package com.example.cathay.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Getter
@Setter
public class CoinDeskResponse {
    private String disclaimer;
    private String chartName;
    private Time updateTime;
    private List<Bpi> BpiList;

    @Getter
    @Setter
    public class Time {
        private String updated;
        private String updatedISO;
        private String updatedUk;
    }
    @Getter
    @Setter
    public class Bpi {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        private float rate_float;
    }
}