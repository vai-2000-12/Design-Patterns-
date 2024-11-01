// Step 1: Template Class with Hook
abstract class Game {
    // Template method, final so subclasses can't override it
    public final void play() {
        initialize();
        startPlay();
        halfTime();  // Hook method : its just a Method that An Optional Mtehod to the subclass if they want to override that Method or not 
        endPlay();
    }

    // Common steps (same for all games)
    protected void initialize() {
        System.out.println("Game initialized!");
    }

    protected void endPlay() {
        System.out.println("Game ended!");
    }

    // Abstract method (subclass will implement differently)
    protected abstract void startPlay();

    // Hook method (empty by default, can be overridden)
    protected void halfTime() {
        // Optional step for subclasses to override if needed
    }
}

// Step 2: Cricket class (specific implementation)
class Cricket extends Game {
    @Override
    protected void startPlay() {
        System.out.println("Cricket game started. Enjoy the match!");
    }
    
    @Override
    protected void halfTime() {
        System.out.println("Half-time in the Cricket match!");
    }
}

// Step 3: Football class (specific implementation)
class Football extends Game {
    @Override
    protected void startPlay() {
        System.out.println("Football game started. Enjoy the match!");
    }

    // Football does not override halfTime(), so no half-time message
}

// Step 4: Main class to run the games
public class Main1 {
    public static void main(String[] args) {
        Game cricketGame = new Cricket();
        cricketGame.play();
        
        System.out.println();
        
        Game footballGame = new Football();
        footballGame.play();
    }
}
