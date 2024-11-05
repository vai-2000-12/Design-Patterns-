interface State{
     void play(MediaPlayer player);
     void pause(MediaPlayer player);
     void stop(MediaPlayer player);
}

class PlayingState implements State{

    @Override
    public void play(MediaPlayer player) {
           System.out.println("Already Playing");    
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Playing Stopped");
        player.setState(new PauseState());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Player Stopped");
        player.setState(new StoppedState());
    }
    
}   

class PauseState implements State{
    @Override
    public void play(MediaPlayer player){
       System.out.println("Playing resumed");
       player.setState(new PlayingState());
    }
    
    @Override
    public void pause(MediaPlayer player){
         System.out.println("Already Paused");
    }

    @Override
    public void stop(MediaPlayer player){
       System.out.println("Stopped playing");
       player.setState(new StoppedState());
    }
}  

class StoppedState implements State{
  
    @Override 
    public void play(MediaPlayer player) {
        System.out.println("Starting playback.");
        player.setState(new PlayingState()); // Transition to PlayingState
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Cannot pause. Media is stopped.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Already stopped.");
    }

}

class MediaPlayer{
    private State state;

    public MediaPlayer(){
       this.state = new StoppedState(); // By Default the Media Player Is In the Stopped State:-
    }

    public void setState(State state){
     this.state = state;
    }


    public void play(){
        state.play(this);
    }

    public void pause(){
        state.pause(this);
    }

    public void stop(){
        state.stop(this);
    }
}
class A{
    public static void main(String[] args) {
        MediaPlayer mp  = new MediaPlayer();
        mp.play();
        mp.pause();
        mp.stop();
        mp.stop();
        mp.pause();
        mp.play();
    }
}

// Used the State Pattern to Design the Media Player..