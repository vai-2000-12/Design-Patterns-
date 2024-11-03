
import java.util.*;

interface Iterator {
    boolean hasNext();
    String next();
}

class NameIterator implements Iterator{
    private List<String>names;
    private int position = 0;
  
    public NameIterator(List<String> names){
      this.names = names;
    }

    public boolean hasNext(){
        return position < names.size();
    }

    public String next(){
        if(this.hasNext()){
            return names.get(position++);
        }
        return null;
    }

}
class NameCollection{
    List<String> names = new ArrayList<>();
    
    public void addName(String name) {
        names.add(name);
    }

    public Iterator iterator(){
         return new NameIterator(names);
    }
}

public class IteratorPattern{
     public static void main(String[] args) {
       NameCollection nc = new NameCollection();
       nc.addName("Rahul");
       nc.addName("Neeraj");
       nc.addName("Om");
    //    nc.addName(null);


       Iterator iterator = nc.iterator();
       while(iterator.hasNext()){
        System.out.println(iterator.next());
       }
     }
}