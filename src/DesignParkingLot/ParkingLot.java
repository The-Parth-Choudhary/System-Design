package DesignParkingLot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<ParkingFloor> floors;
    private SpotAllocationStrategy allocationStrategy;

    private ParkingLot(List<ParkingFloor> floors) {
        this.floors = new ArrayList<>(floors);
    }

    public static ParkingLot getInstance(List<ParkingFloor> floors){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null){
                    instance = new ParkingLot(floors);
                }
            }
        }

        return instance;
    }

    public static ParkingLot getInstance(){
        if (instance == null) {
            throw new IllegalStateException("Parking Lot is not initialized yet.");
        }
        return instance;
    }

    // Dynamic setter allows you to change behavior at runtime!
    public void setAllocationStrategy(SpotAllocationStrategy strategy) {
        this.allocationStrategy = strategy;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        return allocationStrategy.findSpot(this.floors, vehicle);
    }

    public boolean unparkVehicle(String spotId){
        for (ParkingFloor floor : floors){
            if(floor.releaseSpot(spotId)){
                return true;
            }
        }

        return false;
    }

    public List<ParkingFloor> getFloors() { return Collections.unmodifiableList(floors); }
}
