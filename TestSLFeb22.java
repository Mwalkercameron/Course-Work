/** Simplest singly linked list implementation illustration 
Todo: add a toString and modify the main method to add values into
the linked list and display them on screen for verification
+ add an element to the back
+remove the first element 
+remove last element
+Find if an element exists
+remove a specific element
*@Author Monte Cameron
*@Date 2-24-2022
*@Instructor Ken Nyugen
*Data Structures
*/



/** singly linked list */
class SL{
  private Node head;
  private Node tail;
  
  //default constructor that does not do anything yet
  public SL(){
     this.head = null;
     this.tail = null;	  
  }
  
  
  //add an element to the front of the list
  public void addFront(int a){
	Node tmp = new Node(a);    
	   if(this.head != null)
	      tmp.next = this.head;
	   this.head = tmp;
  }
  
  //add an element to the back of the list
  public void addLast(int a){
      if(this.head == null){ //if head is null then list is empty
         addFront(a);
       }else{
         Node tmp = this.head;
         while(tmp.next != null)
            tmp=tmp.next;
         tmp.next = new Node(a);
       }
   }
   
  /* public Node removeFirst(Node head){
      //if(head == null) //nothing to remove if empty
        // return null;
      Node tmp = this.head;
      this.head = this.head.next;
      
      return head;
   }
   
*/  
  /** count the number of nodes */
  public int size(){
    int count = 0;
    Node tmp = this.head;
	while(tmp != null){
	  count++;
	  tmp = tmp.next;
	}
    return count;	
  }
  
  public boolean find(int key){
       return(findNode(key) != null);
  }
  
  /** find a given value in the list
      @param key - the value to look for in the list
      @return 
         +null if the key is not in the list
         + the head if the key is the only node
         + the reference to the node before the key  
  */ 
  private Node findNode(int key){
      if(this.head == null) //empty list
         return null;
       if(this.head.next == null){ //one node in the list
         if(this.head.data == key)
            return this.head;
         return null;
       }
       //multiple nodes in the list
       Node tmp = this.head;
       if(tmp.data == key) //key is in the first node
         return tmp;
       while(tmp.next != null){
         if(tmp.next.data == key)
            return tmp;
          tmp = tmp.next;
       }
         return null; //not found        
   }
   
   /** remove an element 
      @return first instance of value and return true if an element was in the list
      @param key - the value to look for
   
   
   public boolean remove(int key){
      Node tmp = findNode(key);
      if(tmp == null) //the key is not in the list
         return false;
      if(tmp == this.head){ //remove first
         tmp = tmp.next;
         this.head.next = null; //cut the link
         this.head = tmp; //point head at the node after
      }
      
      /*
      Node tmp2 = tmp;
      tmp.next = tmp.next.next;
      tmp2;
      
   }
 */
  
  /** return the content of the list as a space fused string */
  public String toString(){
	String output = "";
	Node tmp = this.head;
	while(tmp != null){
	  output += " " + tmp.data; //grab the data
      tmp = tmp.next; //go to the next node	  
	}
	
    return output;	
  }
  
  /** nested node class to encapsulate stored data */
  private class Node{
    private int data;
    private Node next;
  
    //constructor
    public Node(int data){
      this.data = data;
	  this.next = null;
    }  
  }
}

/** a driver class to test the linked list */

public class TestSLFeb22{
  public static void main(String[] args){
    SL myList  = new SL();  
    myList.addFront(3);
	 myList.addFront(9);
	 myList.addFront(1);
    myList.addLast(8); //test addLast method
    myList.addLast(5);
	 myList.addLast(4);
   
   //myList.removeFirst();
	System.out.println(myList);
	System.out.println(myList.size());
   int a = 9;
   if(myList.find(a))
      System.out.println(" Found " + a);
    else
      System.out.println(" Not found " + a);
  }
}






