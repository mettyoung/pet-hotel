package com.mettyoung.pethotel;

class Suite {
    private String name;
    private int totalVacantRooms;
    private int totalOccupiedRooms;
    private int totalRooms;

    Suite(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setRoomCount(int totalRooms) {
        this.totalRooms = totalRooms;
        this.totalOccupiedRooms = 0;
        this.totalVacantRooms = totalRooms;
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
}
