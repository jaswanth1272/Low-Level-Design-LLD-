package RidePool;

interface Vehicle {
    String getNum();
    VehicleType getType();
}

class Car implements Vehicle{
    protected final String vehicleNum;

    public Car(String id) {
        this.vehicleNum = id;
    }

    public VehicleType getType() {
        return VehicleType.CAR;
    }

    public String getNum(){
        return vehicleNum;
    }
    
}

class Bike implements Vehicle{
    protected final String vehicleNum;

    public Bike(String id) {
        this.vehicleNum = id;
    }

    public VehicleType getType() {
        return VehicleType.BIKE;
    }

    public String getNum(){
        return vehicleNum;
    }
    
}

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String num){
        if (type.equalsIgnoreCase("BIKE")) {
            return new Bike(num);
        } else if (type.equalsIgnoreCase("CAR")) {
            return new Car(num);
        }
        return null;
    }
}
