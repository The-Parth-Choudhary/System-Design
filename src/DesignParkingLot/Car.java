package DesignParkingLot;

public class Car implements Vehicle {

    private final String numberPlate;
    private final VehicleType type;

    public Car(String numberPlate, VehicleType type){
        this.numberPlate = numberPlate;
        this.type = type;
    }

    @Override
    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public VehicleType getType() {
        return type;
    }
}
