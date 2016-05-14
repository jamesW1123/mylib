package mylib.structs;


public class Queue<T>{

   private int count;
   private Node<T> front, back;
   
   public Queue(){
       
       count = 0;
       front = back = null;
   }
   
   public void enqueue(T element){
       
       Node<T> node = new Node<T>(element);
       
       if(isEmpty()) front = node;       
       else back.setNext(node);
       
       back = node;
       count++;	   
   }
   
   public T dequeue(){
       
       if(isEmpty()) return null;
       
       T current = front.getValue();
       front = front.getNext();
       count--;
       
       if(isEmpty()) back = null;
       
       return current;
   }
   
   
   public boolean isEmpty(){
       
       return count == 0;
   }
   
}
















