package com.mettyoung.pethotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuiteTest {

    @Test
    public void should_be_able_to_create_a_suite_with_a_name() {
        Suite suite = new Suite("Deluxe");
        assertEquals("Deluxe", suite.getName());
    }

    @Test
    public void should_be_able_to_set_number_of_rooms() {
        Suite suite = new Suite("Deluxe");
        assertEquals(0, suite.getTotalRooms());

        suite.specifyRoomCount(3);
        assertEquals(3, suite.getTotalRooms());
    }
}