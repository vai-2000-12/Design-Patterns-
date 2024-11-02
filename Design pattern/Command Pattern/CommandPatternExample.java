// Command Interface
interface Command {
    void execute();
}

// Light Receiver
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }
    
    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// Fan Receiver
class Fan {
    public void turnOn() {
        System.out.println("The fan is on.");
    }
    
    public void turnOff() {
        System.out.println("The fan is off.");
    }
}

// Concrete Command to turn on the light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command to turn off the light
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Concrete Command to turn on the fan
class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }
}

// Concrete Command to turn off the fan
class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }
}

// Invoker - Remote Control
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Main Class
public class CommandPatternExample {
    public static void main(String[] args) {
        // Receivers
        Light light = new Light();
        Fan fan = new Fan();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        // Invoker - Remote Control
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();

        // Turn the fan on
        remote.setCommand(fanOn);
        remote.pressButton();

        // Turn the fan off
        remote.setCommand(fanOff);
        remote.pressButton();
    }
}
