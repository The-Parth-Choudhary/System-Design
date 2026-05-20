package DesignParkingLot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private final String floorId;
    private final List<ParkingSpot> spots;
    private final Map<String, ParkingSpot> spotLookupMap;

    public ParkingFloor(String floorId, List<ParkingSpot> spots) {
        this.floorId = floorId;
        this.spots = spots;
        this.spotLookupMap = new HashMap<>();

        for(ParkingSpot spot : spots){
            spotLookupMap.put(spot.getSpotId(), spot);
        }
    }

    public synchronized ParkingSpot allocateSpot(Vehicle vehicle){
        for (ParkingSpot spot : spots){
            if(spot.canFit(vehicle)){
                if(spot.assign(vehicle)){
                    return spot;
                }
            }
        }

        return null;
    }

    public synchronized boolean releaseSpot(String spotId){
        ParkingSpot spot = spotLookupMap.get(spotId);

        if(spot != null && spot.isOccupied()){
            spot.free();
            return true;
        }

        return false;
    }

    public String getFloorId() { return floorId; }
    public List<ParkingSpot> getSpots() { return Collections.unmodifiableList(spots); }
}
