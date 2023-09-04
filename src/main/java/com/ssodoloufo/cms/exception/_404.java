package com.ssodoloufo.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class _404 extends RuntimeException {
    
    /* constructor */
    public _404(String errorMsg) {

        super(errorMsg);
    }
}
