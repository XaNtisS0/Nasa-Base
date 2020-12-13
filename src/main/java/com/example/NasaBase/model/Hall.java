package com.example.NasaBase.model;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    private final int capacity;
    private List<SpaceVehicle> vehicles = new ArrayList<>();

    public Hall(int capacity) {
        this.capacity = capacity;
    }

    public int howMuchFreeSpace() {
        return capacity - howMuchUsedVehicles();
    }

    public int howMuchUsedVehicles() {
        int spaceUsedByVehicles = 0;
        for (SpaceVehicle i: this.vehicles) {
            spaceUsedByVehicles += i.getSize();
        }
        return spaceUsedByVehicles;
    }
}
