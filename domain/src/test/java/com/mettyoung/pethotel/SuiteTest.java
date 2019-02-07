package com.mettyoung.pethotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuiteTest {

    private Suite suite;

    @BeforeEach
    void setup_world() {
        suite = new Suite("Deluxe");
    }

    @Test
    void should_be_able_to_create_a_suite_with_a_name() {
        assertEquals("Deluxe", suite.getName());
    }

    @Test
    void should_be_able_to_set_number_of_rooms() {
        assertEquals(0, suite.getTotalRooms());

        suite.setRoomCount(3);
        assertEquals(3, suite.getTotalRooms());
    }

    @Test
    void should_be_able_to_keep_track_room_stats_if_a_booking_is_made() throws SuiteFullException {
        suite.setRoomCount(3);

        new Customer().book(suite);

        assertEquals(3, suite.getTotalRooms());
        assertEquals(2, suite.getTotalVacantRooms());
        assertEquals(1, suite.getTotalOccupiedRooms());
    }

    @Test
    void should_be_able_to_limit_the_bookings_to_available_rooms_only() throws SuiteFullException {
        suite.setRoomCount(2);

        new Customer().book(suite);
        new Customer().book(suite);
        assertThrows(SuiteFullException.class, () -> new Customer().book(suite), "The suite cannot accommodate more than 2");
    }

    @Test
    void should_be_able_to_clear_all_room_stats_of_a_suite() throws SuiteFullException {
        suite.setRoomCount(2);

        new Customer().book(suite);
        suite.clearAllBookings();

        assertEquals(2, suite.getTotalRooms());
        assertEquals(2, suite.getTotalVacantRooms());
        assertEquals(0, suite.getTotalOccupiedRooms());
    }
}