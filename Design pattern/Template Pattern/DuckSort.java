import java.util.Arrays;

class Duck implements Comparable<Duck>{
    String name;
    int weight;

    public Duck(String name , int weight ){
        this.name= name;
        this.weight = weight;
    }

    public String toString(){
        return name + " weights " + weight;
    }

    public int compareTo(Duck otherDuck){
       
        if(this.weight < otherDuck.weight){
            return -1;
        }else if(this.weight == otherDuck.weight){
            return 0;
        }else{
            return 1;
        }
    }
}

public class DuckSort{
     public static void main(String[] args) {
        Duck [] newDuck =  {
                new Duck("Mallard", 8),
                new Duck("Rubber", 2),
                new Duck("Wooden", 4),
                new Duck("Howard", 6),
                new Duck("Buey", 3),
                new Duck("Daffy", 2),

        };

            System.out.println("Before Sorting");
            display(newDuck);

            Arrays.sort(newDuck);

            System.out.println("\nAfter sorting:");
                display(newDuck);
             }
        
            private static void display(Duck[] newDuck) {
                for(Duck d : newDuck){
                    System.out.println(d);
                }
            }
}