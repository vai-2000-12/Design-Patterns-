interface image{
    void display();
}

class RealImage implements image{
   private String  fileName;

   public RealImage(String fileName){
    this.fileName = fileName;
    loadFromDisk();
   }
   
    public void loadFromDisk(){
      System.out.println("Loading...."+ fileName); 
    }

    public void display(){
        System.out.println("Displaying...." + fileName);
    }
}

class ProxyRealImage implements image{

    private RealImage realImage;
    private String fileName;

    public ProxyRealImage(String fileName){
         this.fileName = fileName;
    }

    public void display(){
        // Lazy Initialization ... of the Object
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
class A{
    public static void main(String[] args) {
        image img1 = new ProxyRealImage("image1.jpg");
        image img2 = new ProxyRealImage("image2.jpg");

         img1.display();// Loads When this Display() method for the first Time

         img1.display(); // Now if you call 

         img2.display();
         
         img2.display();
    }
}