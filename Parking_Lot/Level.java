package Parking_Lot;

import java.util.*;

public class Level {
    private final int level;
    private final List<ParkingSpot> spots;

    public Level(int level, int bikeSpots, int carSpots, int truckSpots){
        this.level = level;
        spots = new ArrayList<>(bikeSpots+carSpots+truckSpots);
        int num=0;
        for(int i=0;i<bikeSpots;i++){
            num++;
            spots.add(new ParkingSpot(num, VehicleType.MOTORCYCLE));
        }
        for(int i=0;i<carSpots;i++){
            num++;
            spots.add(new ParkingSpot(num, VehicleType.CAR));
        }
        for(int i=0;i<truckSpots;i++){
            num++;
            spots.add(new ParkingSpot(num, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSpotType() == vehicle.getType()) {
                spot.assignVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getVehicle().equals(vehicle)) {
                spot.removeVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + level + " Availability:");
        for (ParkingSpot spot : spots) {
            System.out.println("Spot " + spot.getSpotId() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getSpotType());
        }
    }

    public int getLevel(){
        return this.level;
    }
}
