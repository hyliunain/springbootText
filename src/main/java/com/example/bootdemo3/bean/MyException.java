package com.example.bootdemo3.bean;

import lombok.Data;

@Data
public class MyException {
    private int status;
    private String error;
    private String timestamp;
    private String message;
    private String path;
}
