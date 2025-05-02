package Parking_Lot;

public abstract class Vehicle {
    protected final String vehicleId;
    protected final VehicleType type;

    public Vehicle(String id, VehicleType type){
        this.vehicleId = id;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}
