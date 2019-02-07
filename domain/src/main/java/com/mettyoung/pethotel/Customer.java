package com.mettyoung.pethotel;

class Customer {
    void book(Suite suite) throws SuiteFullException {
        suite.book();
    }
}
