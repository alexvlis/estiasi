package com.estiasi.exceptions;

public class DuplicateEntityFoundException extends Exception {

    private String message;
    private Object[] args;

    public DuplicateEntityFoundException(Class<?> clazz, Integer id) {
        this.message = "Duplicate entity " + clazz.getSimpleName() + " found with id " + id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

}
