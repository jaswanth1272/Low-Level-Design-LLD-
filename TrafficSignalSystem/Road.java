package TrafficSignalSystem;

public class Road {
    private final String id;
    private final String name;
    private TrafficLight trafficLight;
    
    public Road(String id, String name){
        this.id=id;
        this.name=name;
    }

    public void setTrafficLight(TrafficLight light){
        this.trafficLight=light;
    }

    public TrafficLight getTrafficLight(){
        return trafficLight;
    }

    public String getId(){
        return id;
    }
}
