package com.mettyoung.pethotel;

class Suite {
    private String name;
    private int totalVacantRooms;
    private int totalOccupiedRooms;
    private int totalRooms;

    Suite(String name, int totalRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        clearAllBookings();
    }

    String getName() {
        return name;
    }

    void setRoomCount(int totalRooms) {
        this.totalRooms = totalRooms;
        clearAllBookings();
    }

    int getTotalRooms() {
        return totalRooms;
    }

    void book() throws SuiteFullException {
        if (totalOccupiedRooms == totalRooms) {
            throw new SuiteFullException(totalRooms);
        }
        totalOccupiedRooms++;
        totalVacantRooms--;
    }

    int getTotalVacantRooms() {
        return totalVacantRooms;
    }

    int getTotalOccupiedRooms() {
        return totalOccupiedRooms;
    }

    void clearAllBookings() {
        this.totalOccupiedRooms = 0;
        this.totalVacantRooms = totalRooms;
    }

    void addRooms(int numberOfRooms) {
        this.totalRooms += numberOfRooms;
        this.totalVacantRooms += numberOfRooms;
    }

    void removeRooms(int numberOfRooms) {
        if (this.totalVacantRooms < numberOfRooms) {
            throw new SuiteOverReductionException(this.totalVacantRooms);
        }
        this.totalRooms -= numberOfRooms;
        this.totalVacantRooms -= numberOfRooms;
    }
}
