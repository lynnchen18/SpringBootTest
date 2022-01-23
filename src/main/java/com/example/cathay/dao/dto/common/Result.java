package com.example.cathay.dao.dto.common;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T> implements Serializable {
    private T data;
    private boolean success;

    public Result (T data) {
        this.data = data;
        this.success = false;
    }

    public boolean isSuccess() {
        return success;
    }
}
