// Subsystems
class Engine {
    public void start() {
        System.out.println("Engine Started");
    }
}

class AirConditioner {
    public void turnOn() {
        System.out.println("AC Turned On");
    }
}

class MusicSystem {
    public void playMusic() {
        System.out.println("Music Playing");
    }
}

// Facade
class CarFacade {
    private Engine engine;
    private AirConditioner ac;
    private MusicSystem music;

    public CarFacade() {
        engine = new Engine();
        ac = new AirConditioner();
        music = new MusicSystem();
    }

    public void startCar() {
        engine.start();
        ac.turnOn();
        music.playMusic();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        CarFacade car = new CarFacade();
        car.startCar();
    }
}
