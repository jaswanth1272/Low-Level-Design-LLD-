package RidePool;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class RideController {
    private static RideController instance;
    private final List<Rider> riderQueue = new CopyOnWriteArrayList<>();
    private final List<Pooler> poolerQueue = new CopyOnWriteArrayList<>();
    private final List<Ride> activeRides = new CopyOnWriteArrayList<>();
    private int currentTime = 0;

    private RideController() {
        startMatcherThread();
        startTimer();
    }

    public static RideController getInstance() {
        if(instance==null){
            instance = new RideController();
        }
        return instance;
    }

    public void addRider(Rider rider) {
        riderQueue.add(rider);
    }

    public void addPooler(Pooler pooler) {
        poolerQueue.add(pooler);
    }

    public void addRide(Ride ride) {
        activeRides.add(ride);
    }

    public List<Ride> getActiveRides() {
        return activeRides;
    }

    public List<Rider> getRiderQueue() {
        return riderQueue;
    }

    public List<Pooler> getPoolerQueue() {
        return poolerQueue;
    }

    private void startTimer() {
        Thread timerThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    currentTime++;
                    System.out.println("current time: "+currentTime);
                    checkRides();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.setDaemon(true);  // So it doesn't block app shutdown
        timerThread.start();
    }

    private void checkRides() {
        List<Ride> ridesToRemove = new ArrayList<>();
        for (Ride ride : activeRides) {
            Rider rider = ride.getRider();
            Pooler pooler = ride.getPooler();

            if (ride.getStatus()==0) {
                if(currentTime >= pooler.getStartTime()){
                    ride.poolerStarted();
                    pooler.moveOneStep();
                }
            }

            else if(ride.getStatus()==1){
                if(currentTime >= rider.getStartTime()){
                    if (!pooler.getLocation().equals(rider.getSource())) {
                        ride.riderWaiting();
                    } else {
                        ride.setRideStarted();
                        List<Place> path = Path.getPath(pooler.getLocation(), rider.getDestination());
                        pooler.setPathToFollow(path);
                    }
                }
                pooler.moveOneStep();
            }

            else{
                if(pooler.getLocation().equals(rider.getDestination())){
                    ride.rideEnded();
                    ridesToRemove.add(ride);
                }
                else{
                    pooler.moveOneStep();
                }
            }
        }
        activeRides.removeAll(ridesToRemove);
    }

    private void startMatcherThread() {
        Thread matcherThread = new Thread(() -> {
            while (true) {
                try {
                    matchRides();
                    Thread.sleep(1000); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        matcherThread.setDaemon(true);  // so it doesn't block app shutdown
        matcherThread.start();
    }

    public void matchRides() {
        List<Rider> ridersToRemove = new ArrayList<>();
        Pooler matchedPooler = null;
        for (Rider r : riderQueue) {
            matchedPooler = null;
            for (Pooler p : poolerQueue) {
                int fare = Math.abs(r.getSource().x-r.getDestination().x)+Math.abs(r.getSource().y-r.getDestination().y);
                if (canMatch(r, p)==true && p.acceptRide(r, fare)==1) {
                    matchedPooler = p;
                    Ride ride = new Ride(p, r, fare);
                    addRide(ride);
                    ridersToRemove.add(r);
                    System.out.println("Ride matched: " + p.getName()+ " "+ r.getName());
                    break;
                }
            }
            if (matchedPooler != null){
                poolerQueue.remove(matchedPooler);
            }
        }
        riderQueue.removeAll(ridersToRemove);
    }

    private boolean canMatch(Rider r, Pooler p) {
        if((Math.abs(r.source.x-p.source.x)+Math.abs(r.source.y-p.source.y)<=2) && (Math.abs(r.destination.x-p.destination.x)+Math.abs(r.destination.y-p.destination.y)<=2)
        && p.startTime+1 <= r.startTime && p.getSeats()>=r.getSeats()){
            return true;
        }
        return false;
    }
}
