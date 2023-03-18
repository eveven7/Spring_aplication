package com.swedbank.StudentApplication.student.model.exception;

public class RoomsNotFoundException extends RuntimeException{

    public RoomsNotFoundException(int id ){
        super("No rooms for building " + id);
    }

}