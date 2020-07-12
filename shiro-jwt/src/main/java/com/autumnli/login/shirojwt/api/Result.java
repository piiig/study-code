package com.autumnli.login.shirojwt.api;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result {
    private int code;
    private String message;
    private Object data;

    public static Result succ(Object data) {
        Result r = new Result();
        r.setCode(200).setMessage("success!").setData(data);
        return r;
    }

    public static Result fail(int code, String message) {
        Result r = new Result();
        r.setCode(code).setMessage(message);
        return r;
    }
}
