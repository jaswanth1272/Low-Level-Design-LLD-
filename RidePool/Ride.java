package RidePool;

import java.util.List;

public class Ride {
    protected final Pooler pooler;
    protected final Rider rider;
    protected final int fare;
    protected int rideStatus;

    public Ride(Pooler pooler, Rider rider, int fare){
        this.pooler = pooler;
        this.rider = rider;
        this.fare = fare;
        this.rideStatus = 0;
    }

    public Pooler getPooler(){
        return pooler;
    }

    public Rider getRider(){
        return rider;
    }

    public void poolerStarted(){
        System.out.println("Pooler " + pooler.getId() + " started at " + pooler.getStartTime());
        this.rideStatus=1;
        Place target = rider.getSource();
        List<Place> path = Path.getPath(pooler.getLocation(), target);
        pooler.setPathToFollow(path);
    }

    public int getStatus(){
        return rideStatus;
    }

    public void setRideStarted(){
        this.rideStatus = 2;
        System.out.println("Ride started for Rider " + rider.getId());
    }

    public void riderWaiting(){
        System.out.println("Rider " + rider.getId() + " is waiting...");
    }

    public void rideEnded(){
        System.out.println("Ride ended for "+ rider.getName());
    }
}
