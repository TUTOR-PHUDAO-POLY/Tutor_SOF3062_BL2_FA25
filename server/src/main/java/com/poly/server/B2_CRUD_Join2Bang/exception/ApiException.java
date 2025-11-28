package com.poly.server.B2_CRUD_Join2Bang.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException{

    private String code; // ma loi: T01, T02,...
    // message loi: RuntimeException => co san message loi

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }

}
