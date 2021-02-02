package com.estiasi.exceptions;

public class EntityNotFoundException extends Exception {

    private String message;
    private Object[] args;

    public EntityNotFoundException(Class<?> clazz, Integer id) {
        this.message = "Failed to find entity " + clazz.getSimpleName() + " with id " + id;
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
