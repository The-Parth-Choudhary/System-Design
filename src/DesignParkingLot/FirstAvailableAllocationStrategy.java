package DesignParkingLot;

import java.util.List;

public class FirstAvailableAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors){
            ParkingSpot spot = floor.allocateSpot(vehicle);
            if (spot != null) return spot;
        }

        return null;
    }
}
