package Parking_Lot;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot(){
        this.levels = new ArrayList<>();
        levels.add(new Level(1, 15, 10, 5));
        levels.add(new Level(2, 15, 10, 5));
        levels.add(new Level(3, 15, 10, 5));
    }

    public static synchronized ParkingLot getInstance(){
        if (instance==null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public synchronized boolean parkVehicle(Vehicle v){
        for(Level level:levels){
            if(level.parkVehicle(v)){
                System.out.println("Parked vehicle in level " + level.getLevel());
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
