package com.my.coffee.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {
    private int code;
    private String message;
    private Date timestamp;
    private String description;
}
