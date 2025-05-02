package RidePool;

public class Rider {
    protected final String name;
    protected final int id;
    protected final String mobilenumber;
    protected final VehicleType type;
    protected final int seatsNeeded;
    protected final Place source;
    protected final Place destination;
    protected int startTime;

    public Rider(String name, int id, String mobilenumber, VehicleType type, int seats, Place src, Place dest, int sttime){
        this.name = name;
        this.id = id;
        this.mobilenumber = mobilenumber;
        this.seatsNeeded = seats;
        this.type = type;
        this.source = src;
        this.destination = dest;
        this.startTime = sttime;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return mobilenumber;
    }

    public VehicleType getVehicleType(){
        return type;
    }

    public int getSeats(){
        return seatsNeeded;
    } 

    public Place getSource(){
        return source;
    }

    public Place getDestination(){
        return destination;
    }

    public int getStartTime(){
        return startTime;
    }

    public synchronized void updateStartTime(int time){
        this.startTime = time;
    }
}
