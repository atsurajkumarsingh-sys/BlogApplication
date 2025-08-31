package com.evon.blog.exception;

public class DuplicateRecordException extends RuntimeException{

    public DuplicateRecordException(String msg){
        super(msg);
    }
}
