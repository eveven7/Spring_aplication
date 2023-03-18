package com.swedbank.StudentApplication.student.model.exception;

public class CountryNotFoundException  extends RuntimeException{
    public CountryNotFoundException(String country){

        super("Could not find Country: " + country);
    }
}
