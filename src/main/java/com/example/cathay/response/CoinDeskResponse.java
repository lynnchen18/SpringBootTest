package com.example.cathay.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@Getter
@Setter
public class CoinDeskResponse implements Serializable {
    private String disclaimer;
    private String chartName;
    private UpdateTime time;
    private HashMap<String, Bpi> bpi;

    @Getter
    @Setter
    public class UpdateTime {
        private String updated;
        private String updatedISO;
        private String updateduk;
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