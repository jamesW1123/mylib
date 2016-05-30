package mylib.tree;


public class RBTree<T extends Comparable<T>>{

    //http://www.read.seas.harvard.edu/~kohler/notes/llrb.html


    private RBNode<T> root;
    private int count; // number of Nodes in the tree

    public RBTree(){

	root = new RBNode<T>(null);
	count = 0;
    }

    public void insert(T value){

	if(root.getValue() == null){
	    root = new RBNode<T>(value);
	    count++;
	}
	else{

	    boolean inserted = false;
	    RBNode<T> current = root;
	    RBNode<T> node = new RBNode<T>(value);

	    while(!inserted){

		if(value.compareTo(current.getValue()) <= 0)
		    if(current.getLeft() == null){
			current.setLeft(node);
			inserted = true;
			count++;
		    }
		    else current = current.getLeft();
		else if(current.getRight() == null){
		    current.setRight(node);
		    inserted = true;
		    count++;
		}		
	    }
	}
    }

    public void remove(){

    }

    public Integer find(Integer key){
	return 0;
    }
    public Integer findMin(){return 0;}
    public Integer findMax(){return 0;}
    public boolean isEmpty(){return false;}
    public String toString(){return "";}









}
