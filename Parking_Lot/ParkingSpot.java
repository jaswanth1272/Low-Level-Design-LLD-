package Parking_Lot;

public class ParkingSpot {
    private int spotId;
    private VehicleType spotType;
    private Vehicle vehicle;

    public ParkingSpot(int id, VehicleType type)
    {
        this.spotId = id;
        this.spotType = type;
        this.vehicle = null;
    }

    public boolean isAvailable(){
        return vehicle==null;
    }

    public void assignVehicle(Vehicle v){
        if (vehicle==null && v.getType() == spotType) {
            vehicle = v;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public void removeVehicle(){
        this.vehicle = null;
    }

    public int getSpotId(){
        return this.spotId;
    }

    public VehicleType getSpotType(){
        return this.spotType;
    }
}
