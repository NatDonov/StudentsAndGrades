package com.jb.exam.exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {
    ID_NOT_FOUND("id not found");


    private String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
