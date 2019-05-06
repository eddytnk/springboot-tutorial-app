package com.example.itemservice.advices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User: edward <br/>
 * Date: 5/5/19 9:01 PM <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String code;
    private String errorMessage;
    private String path;
    private Date timestamp;
}
