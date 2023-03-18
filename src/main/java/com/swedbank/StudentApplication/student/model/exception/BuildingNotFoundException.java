package com.swedbank.StudentApplication.student.model.exception;

public class BuildingNotFoundException extends RuntimeException{

    public BuildingNotFoundException(int id ){
        super("No building found for  " + id);
    }
}