package com.example.demo.Utils;
import	java.io.Serializable;

import lombok.Data;

@Data
public class Result<T> implements Serializable{

    private String resultMsg;
    private Object resultData;
    private T data;
}
