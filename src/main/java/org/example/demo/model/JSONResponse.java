package org.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2020-12-30;   Time: 0:00
 */
@Getter
@Setter
@ToString
public class JSONResponse {
    private boolean success;
    private String code;
    private String message;
    private Object data;
}
