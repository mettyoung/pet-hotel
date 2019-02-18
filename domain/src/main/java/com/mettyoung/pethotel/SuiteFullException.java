package com.mettyoung.pethotel;

class SuiteFullException extends RuntimeException {
    SuiteFullException(int limit) {
        super("The suite cannot accommodate more than " + limit);
    }
}
