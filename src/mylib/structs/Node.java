package mylib.structs;


public class Node<T>{

    private T value;
    private Node<T> next;

    public Node(){
	
	this.value = null;
    }

    public Node(T value){
	
	this.value = value;
    }
    
    public void setValue(T value){
	
	this.value = value;
    }
    
    public T getValue(){
	
	return value;
    }
    
    public void setNext(Node<T> node){
	
	this.next = node;
    }
    
    public Node<T> getNext(){
	
	return next;
    }
}












