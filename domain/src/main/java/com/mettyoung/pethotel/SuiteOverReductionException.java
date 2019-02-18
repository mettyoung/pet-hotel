package com.mettyoung.pethotel;

class SuiteOverReductionException extends RuntimeException {
    SuiteOverReductionException(int numberOfVacantRooms) {
        super("The suite cannot be reduced with more than " + numberOfVacantRooms + " vacant rooms");
    }
}
