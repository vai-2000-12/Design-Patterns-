// Step 1: Template Class
abstract class Game {
    // Template method, final taaki subclasses ise override na kar saken
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    // Common steps (sab games ke liye same)
    protected void initialize() {
        System.out.println("Game initialized!");
    }

    protected void endPlay() {
        System.out.println("Game ended!");
    }

    // Abstract method (subclass me alag implement hogi)
    protected abstract void startPlay();
}

// Step 2: Cricket class (specific implementation)
class Cricket extends Game {
    @Override
    protected void startPlay() {
        System.out.println("Cricket game started. Enjoy the match!");
    }
}

// Step 3: Football class (specific implementation)
class Football extends Game {
    @Override
    protected void startPlay() {
        System.out.println("Football game started. Enjoy the match!");
    }
}

// Step 4: Main class to run the games
public class Main {
    public static void main(String[] args) {
        Game cricketGame = new Cricket();
        cricketGame.play();
        
        System.out.println();
        
        Game footballGame = new Football();
        footballGame.play();
      
        

    }
}
