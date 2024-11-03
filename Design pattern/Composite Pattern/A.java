import java.util.ArrayList;
import java.util.List;

// Step 1: Define a common interface for all graphics
interface Graphics{
    void draw();

}

// Step 2: Create leaf classes that implement the Graphic interface
class Square implements Graphics{
    public void draw(){
        System.out.println("Square Drawn");
    }
}

class Circle implements Graphics{
    public void draw(){
        System.out.println("Circle Drawn");
    }
}


// Step 3: Create a composite class that also implements the Graphic interface
// This class can hold multiple Graphic objects, which can be either leaf or composite objects

class CompositeGraphic implements Graphics{
    // A list to store child Graphic objects
    public List<Graphics> children = new ArrayList<>();
     
     // Method to add a child Graphic object
    public void add(Graphics graphic){
        children.add(graphic);
    }
   // Method to remove a child Graphic object
    public void remove(Graphics graphic){
        children.remove(graphic);
    }

    // Implement draw() to call draw() on each child Graphic object
    public void draw(){
        for(Graphics gr : children){
              gr.draw();
        }
    }
}

// Step 4: Client code to use the Composite pattern
class A{
    public static void main(String[] args) {
        CompositeGraphic cg = new CompositeGraphic();

            // Create individual graphic objects (leaves)
        Graphics circle = new Circle();
        Graphics square = new Square();
         
        cg.add(circle);
        cg.add(square);
 
        
        cg.remove(square);

        // Draw the composite graphic
        System.out.println("Drawing the Shapes");
        cg.draw();

    }
}
