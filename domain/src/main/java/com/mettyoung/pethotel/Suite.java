package com.mettyoung.pethotel;

class Suite {
    String name;
    int roomCount;

    Suite(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void specifyRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getTotalRooms() {
        return roomCount;
    }
}
