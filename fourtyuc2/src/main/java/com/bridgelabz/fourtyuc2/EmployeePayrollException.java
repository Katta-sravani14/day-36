package com.bridgelabz.fourtyuc2;



public class EmployeePayrollException extends Exception {
    enum ExceptionType {
        DatabaseException,
    }

    public ExceptionType type;

    public EmployeePayrollException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
