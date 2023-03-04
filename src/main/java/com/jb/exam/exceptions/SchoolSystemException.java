package com.jb.exam.exceptions;


public class SchoolSystemException extends Exception {
    public SchoolSystemException(ErrMsg errMsg) {

        super(errMsg.getMessage());
    }

}
