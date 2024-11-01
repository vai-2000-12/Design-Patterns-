enum Singleton {
   UNIQUE_INSTANCE;

   // Example of a useful field
   private int value;

   // Example of a method to manipulate the field
   public int getValue() {
       return value;
   }

   public void setValue(int value) {
       this.value = value;
   }
}

public class SingletonClient {
   public static void main(String[] args) {
       Singleton sc = Singleton.UNIQUE_INSTANCE;
       
       // Set a value in the Singleton instance
       sc.setValue(100);

       // Retrieve and print the value
       System.out.println("Singleton value: " + sc.getValue());

       // Demonstrates the Singleton nature
       Singleton anotherInstance = Singleton.UNIQUE_INSTANCE;
       System.out.println("Another instance value: " + anotherInstance.getValue());
   }
}