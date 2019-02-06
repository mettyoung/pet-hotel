package com.mettyoung.pethotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuiteTest {

    @Test
    public void should_be_able_to_create_a_suite_with_a_name() {
        Suite suite = new Suite("Deluxe");
        assertEquals("Deluxe", suite.getName());
    }
}