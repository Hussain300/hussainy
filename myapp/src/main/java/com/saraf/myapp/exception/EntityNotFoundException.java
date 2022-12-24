package com.saraf.myapp.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id, Class<?> entity){
        super("the " + entity.getSimpleName().toLowerCase() + " with id " + id + "  exception");
    }
}
