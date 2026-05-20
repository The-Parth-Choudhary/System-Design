package DesignParkingLot;

public class ParkingSpot {

    private final String spotId;
    private final VehicleType supportedType;
    private boolean isOccupied;
    private Vehicle assignedVehicle;

    public ParkingSpot(String spotId, VehicleType supportedType) {
        this.spotId = spotId;
        this.supportedType = supportedType;
        this.isOccupied = false;
        this.assignedVehicle = null;
    }

    public boolean canFit(Vehicle vehicle){
        return !isOccupied && this.supportedType == vehicle.getType();
    }

    public synchronized boolean assign(Vehicle vehicle){
        this.assignedVehicle = vehicle;
        this.isOccupied = true;
        return true;
    }

    public synchronized boolean free(){
        this.assignedVehicle = null;
        this.isOccupied = false;
        return true;
    }

    public String getSpotId() { return spotId; }
    public VehicleType getSupportedType() { return supportedType; }
    public boolean isOccupied() { return isOccupied; }
    public Vehicle getAssignedVehicle() { return assignedVehicle; }
}
