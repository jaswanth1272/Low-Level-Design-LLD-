// Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver: Light
class Light {
    public void on() {
        System.out.println("The light is on.");
    }

    public void off() {
        System.out.println("The light is off.");
    }
}

// Receiver: Fan
class Fan {
    public void start() {
        System.out.println("The fan is spinning.");
    }

    public void stop() {
        System.out.println("The fan has stopped.");
    }
}

// Concrete Command for turning the light on
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

// Concrete Command for turning the light off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

// Concrete Command for starting the fan
class FanStartCommand implements Command {
    private Fan fan;

    public FanStartCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.start();
    }

    public void undo() {
        fan.stop();
    }
}

// Concrete Command for stopping the fan
class FanStopCommand implements Command {
    private Fan fan;

    public FanStopCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.stop();
    }

    public void undo() {
        fan.start();
    }
}

// Invoker: RemoteControl
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndoButton() {
        command.undo();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create receivers
        Light light = new Light();
        Fan fan = new Fan();

        // Create commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanStart = new FanStartCommand(fan);
        Command fanStop = new FanStopCommand(fan);

        // Create invoker
        RemoteControl remoteControl = new RemoteControl();

        // Turn the light on and off
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton(); // Light on
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton(); // Light off

        // Start and stop the fan
        remoteControl.setCommand(fanStart);
        remoteControl.pressButton(); // Fan on
        remoteControl.setCommand(fanStop);
        remoteControl.pressButton(); // Fan off

        // Undoing the last actions
        remoteControl.pressUndoButton(); // Fan on (Undo stop)
        remoteControl.pressUndoButton(); // Light on (Undo off)
    }
}
