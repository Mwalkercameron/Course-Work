/*Illustration of interface*/

interface Sellable{ //a simple interface
   public String sellListing(String name, double price, int qty, String desc);
}  

/* a simple class representing an item to sell */
class Item{
   private String name;
   private String desc;
   private double price;
   private int qty; 
   //constructor
   public Item(String name, double price, int qty, String desc){
      this.name = name;
      this.price = price;
      this.qty = qty;
      this.desc = desc;
   }
      public String toString(){
         return "Name: " + name +"\n Price: " + this.price +"\n Qty: " + this.qty;
      }      
}

class Amazon implements Sellable{
   private Item[] items;
   private int iCount; //number of items in array
   
   //constructor
   public Amazon(){
      this.iCount = 0;
      this.items = new Item[10];
   }
   
   public String sellListing(String name, double price, int qty, String desc){
     this.items[iCount++] = new Item(name, price*1.2, (int)(qty*1.05), desc);
      return "Conf :Amazon received  " + qty + " of " + name + " with price of " + price;
      
   }
}

class Walmart implements Sellable{
   public String sellListing(String name, double price, int qty, String description){
      return "Conf: Walmart received " + qty + " of " + name + " with price of " + price;
   }
}   

public class TestStore{
   public static void main(String[] args){
      Amazon a = new Amazon();
      Walmart w = new Walmart();
   }
}