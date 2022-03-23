package edu.deegrework.StudentManagementSystem.exception;

public class RequiredFieldException extends RuntimeException{

    public RequiredFieldException(String message){
        super(message);
    }
}
