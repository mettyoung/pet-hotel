package com.mettyoung.pethotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuiteTest {

    @Test
    void should_be_able_to_create_a_suite_with_a_name() {
        Suite suite = new Suite("Deluxe");
        assertEquals("Deluxe", suite.getName());
    }

    @Test
    void should_be_able_to_set_number_of_rooms() {
        Suite suite = new Suite("Deluxe");
        assertEquals(0, suite.getTotalRooms());

        suite.setRoomCount(3);
        assertEquals(3, suite.getTotalRooms());
    }

    @Test
    void should_be_able_to_keep_track_room_stats_if_a_booking_is_made() {
        Suite suite = new Suite("Deluxe");
        suite.setRoomCount(3);

        Customer customer = new Customer();
        customer.book(suite);

        assertEquals(3, suite.getTotalRooms());
        assertEquals(2, suite.getTotalVacantRooms());
        assertEquals(1, suite.getTotalOccupiedRooms());
    }
}