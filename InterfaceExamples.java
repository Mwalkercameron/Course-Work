interface Turnable{
   public abstract void turn(); //<------ abstract method named "turn"
}

class Leaf implements Turnable{
   public void turn(){
      System.out.println("changing colors.");
   }   
}


abstract class Document{
   private String text;
   
   public Document(String text){
      this.text = text;
    
    }
    public String toString(){
      return "Contents: \n " + text;
    }
}

//page class
class Page extends Document implements Turnable, Comparable<Page>{
   private int pageNum;
   
   public Page(int pageNum, String text){
      super(text);
      this.pageNum = pageNum;
    }
    public void turn(){
      System.out.println("going to different page.");
    }
    
    @Override
    /* Compares two pages by their page number
    If the calling object's (this) page number is less than
    the parameter (that), return -x, when x is the difference
    b/t the page numbers
    If the calling object's page number is greater than the parameter
    return x. Otherwise, return 0.
    @param the page number to compare
    
    */
    public int compareTo(Page that){
      return this.pageNum - that.pageNum;
    }
} 
       
//Driver
public class InterfaceExamples{
   public static void main(String[] args){
      Leaf L = new Leaf();
      L.turn();
      
      Page p = new Page(29, "Every good boy does fine.");
      p.turn();
      System.out.println(p);
      
      Page p2 = new Page(36, "Hello");
      System.out.println(p.compareTo(p2));
      Page p3 = new Page(24, "stuff");
      System.out.println(p.compareTo(p3));
      System.out.println(p.compareTo(p));      
   }
}   
