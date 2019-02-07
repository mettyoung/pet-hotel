package com.mettyoung.pethotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuiteTest {

    private Suite suite;

    @BeforeEach
    void setup_world() {
        suite = new Suite("Deluxe", 3);
    }

    @Test
    void should_be_able_to_create_a_suite_with_a_name_and_initial_room_size() {
        Suite suite = new Suite("Deluxe", 3);
        assertEquals("Deluxe", suite.getName());
        assertEquals(3, suite.getTotalRooms());
        assertEquals(3, suite.getTotalVacantRooms());
        assertEquals(0, suite.getTotalOccupiedRooms());
    }

    @Test
    void should_be_able_to_keep_track_room_stats_if_a_booking_is_made() throws SuiteFullException {
        new Customer().book(suite);

        assertEquals(3, suite.getTotalRooms());
        assertEquals(2, suite.getTotalVacantRooms());
        assertEquals(1, suite.getTotalOccupiedRooms());
    }

    @Test
    void should_be_able_to_limit_the_bookings_to_available_rooms_only() throws SuiteFullException {
        new Customer().book(suite);
        new Customer().book(suite);
        new Customer().book(suite);
        assertThrows(SuiteFullException.class, () -> new Customer().book(suite), "The suite cannot accommodate more than 2");
    }

    @Test
    void should_be_able_to_clear_all_room_stats_of_a_suite() throws SuiteFullException {
        new Customer().book(suite);
        suite.clearAllBookings();

        assertEquals(3, suite.getTotalRooms());
        assertEquals(3, suite.getTotalVacantRooms());
        assertEquals(0, suite.getTotalOccupiedRooms());
    }
}