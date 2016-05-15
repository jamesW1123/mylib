package mylib.tree;

public class RBTreeNode<T>{

    private boolean color; //red == true  black == false
	private RBTreeNode<T> parent, left, right;
	private T value;

	public RBTreeNode(){

	    parent = left = right = null;
	    color = true;
	    this.value = null;
	}	

	public RBTreeNode(T value){

	    parent = left = right = null;
	    color = true;
	    this.value = value;
	}
	
	public void changeColor(){
	    this.color = !this.color;
	}
	
	public boolean isRed(){
	    return this.color;
	}

	public T getValue(){
	    return value;
	}
}

