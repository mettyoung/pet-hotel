package com.mettyoung.pethotel;

class SuiteFullException extends Exception {
    SuiteFullException(int limit) {
        super("The suite cannot accommodate more than " + limit);
    }
}
