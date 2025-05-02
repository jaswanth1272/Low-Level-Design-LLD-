package RidePool;

import java.util.ArrayList;
import java.util.List;

public class Pooler {
    protected final String name;
    protected final int id;
    protected final String mobilenumber;
    protected final Vehicle vehicle;
    protected final int seatsAvailable;
    protected final Place source;
    protected final Place destination;
    protected final int startTime;
    protected Place location;
    private List<Place> pathToFollow = new ArrayList<>();

    public Pooler(String name, int id, String mobilenumber, Vehicle veh, int seats, Place src, Place dest, int startTime){
        this.name = name;
        this.id = id;
        this.mobilenumber = mobilenumber;
        this.vehicle = veh;
        this.seatsAvailable = seats;
        this.source = src;
        this.destination = dest;
        this.startTime = startTime;
        this.location = src;
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

    public Vehicle getVehicle(){
        return vehicle;
    }

    public int getSeats(){
        return seatsAvailable;
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

    public Place getLocation(){
        return location;
    }

    public void setPathToFollow(List<Place> path) {
        this.pathToFollow = path;
    }

    public void moveOneStep() {
        if (!pathToFollow.isEmpty()) {
            this.location = pathToFollow.remove(0);
        }
    }

    public int acceptRide(Rider r, int fare){
        return (int)(Math.random() * 2);
    }
}
