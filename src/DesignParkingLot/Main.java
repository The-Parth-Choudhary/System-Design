package DesignParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING STRATEGY-BASED PARKING LOT ===");

        // 1. Configure Floor 1 (1 Compact, 1 Large)
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot("F1-COMPACT", VehicleType.CAR));
        floor1Spots.add(new ParkingSpot("F1-LARGE", VehicleType.SUV));
        ParkingFloor floor1 = new ParkingFloor("Floor-1", floor1Spots);

        // 2. Configure Floor 2 (1 Compact, 1 Large)
        List<ParkingSpot> floor2Spots = new ArrayList<>();
        floor2Spots.add(new ParkingSpot("F2-COMPACT", VehicleType.CAR));
        floor2Spots.add(new ParkingSpot("F2-LARGE", VehicleType.SUV));
        ParkingFloor floor2 = new ParkingFloor("Floor-2", floor2Spots);

        List<ParkingFloor> allFloors = new ArrayList<>();
        allFloors.add(floor1);
        allFloors.add(floor2);

        // 3. Initialize Singleton Parking Lot
        ParkingLot parkingLot = ParkingLot.getInstance(allFloors);

        // --- PHASE 1: Using First Available Strategy ---
        System.out.println("\n--- Phase 1: Applying 'First Available' Strategy ---");
        parkingLot.setAllocationStrategy(new FirstAvailableAllocationStrategy());

        Vehicle car1 = new Car("AAA-111", VehicleType.CAR);
        Vehicle car2 = new Car("BBB-222", VehicleType.CAR);

        // Car 1 should go to Floor 1 because it's scanned first
        ParkingSpot spot1 = parkingLot.parkVehicle(car1);
        System.out.println("Car 1 (" + car1.getNumberPlate() + ") assigned to: " + spot1.getSpotId());
        // Expected: F1-COMPACT

        // Car 2 fills up the next available, cascading to Floor 2
        ParkingSpot spot2 = parkingLot.parkVehicle(car2);
        System.out.println("Car 2 (" + car2.getNumberPlate() + ") assigned to: " + spot2.getSpotId());
        // Expected: F2-COMPACT

        System.out.println("\n[System Notice] Resetting car positions to test rule changes...");
        parkingLot.unparkVehicle("F1-COMPACT");
        parkingLot.unparkVehicle("F2-COMPACT");
    }
}
