// Step 1: Define the State interface with a method for handling state change
interface State {
    void handleButtonPress(Fan fan);
}

// Step 2: Implement specific states (Off, Low, and High) which change the fan's behavior

// Off State
class OffState implements State {
    @Override
    public void handleButtonPress(Fan fan) {
        System.out.println("Fan is now on Low speed.");
        fan.setState(new LowState()); // Change state to Low
    }
}

// Low Speed State
class LowState implements State {
    @Override
    public void handleButtonPress(Fan fan) {
        System.out.println("Fan is now on High speed.");
        fan.setState(new HighState()); // Change state to High
    }
}

// High Speed State
class HighState implements State {
    @Override
    public void handleButtonPress(Fan fan) {
        System.out.println("Fan is now off.");
        fan.setState(new OffState()); // Change state to Off
    }
}

// Step 3: Context class (Fan) that maintains the current state
class Fan {
    private State currentState;

    public Fan() {
        currentState = new OffState(); // Initial state is Off
    }

    // Method to set a new state
    public void setState(State state) {
        currentState = state;
    }

    // Method to press the button and change the state
    public void pressButton() {
        currentState.handleButtonPress(this);
    }
}

// Step 4: Client code to test the State Pattern
public class StatePatternExample {
    public static void main(String[] args) {
        Fan fan = new Fan(); // Create a fan instance with initial Off state

        // Press the button multiple times to change states
        fan.pressButton(); // Fan is now on Low speed.
        fan.pressButton(); // Fan is now on High speed.
        fan.pressButton(); // Fan is now off.
        fan.pressButton(); // Fan is now on Low speed again.
    }
}
