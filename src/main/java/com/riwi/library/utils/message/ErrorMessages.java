package com.riwi.library.utils.message;

public class ErrorMessages{
    public static final String RequiredUsername = "The username is required";    
    public static final String RequiredPassword= "Password is required";    
    public static final String RequiredEmail= "Email is required";
    public static final String RequiredFullName= "Full name is required"; 
    public static final String RequiredRole= "The role must be 'EMPLOYEE' or 'CUSTOMER'";     
    
    public static String IdNotFound(String entity) {

        final String message = "There are no records with entity %s with the supplied id";
        return String.format(message, entity);
    }
}
