package mylib.tree;


public class RBTree<T extends Comparable<T>, V  extends Comparable<V>>{
	
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node{
	
	T key;
	V value;
	Node left, right;
	int N;
	boolean color;
	
	Node(T key, V value, int N, boolean color){
	    
	    this.key = key;
	    this.value = value;
	    this.N = N;
	    this.color = color;
	}
    }
    
    private boolean isRed(Node node){

	if(node == null) return false;
	return node.color == RED;
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


    private Node rotateLeft(Node node){
	
	Node temp = node.right;
	node.right = temp.left;
	temp.left = node;
	temp.color = node.color;
	node.color = RED;
	temp.N = node.N;
	node.N = size(node.left) + size(node.right) + 1;
	
	return temp;
    }
    
    private Node rotateRight(Node node){
	
	Node temp = node.left;
	node.left = temp.right;
	temp.right = node;
	temp.color = node.color;
	node.color = RED;
	temp.N = node.N;
	node.N = size(node.left) + size(node.right) + 1;
	
	return temp;
    }

    private void flipColors(Node node){
	
	node.color = RED;
	node.left.color = BLACK;
	node.right.color = BLACK;
    }
    
    public int size(){
	
	return size(root);
    }
    
    private int size(Node node){
	
	if(node == null) return 0;
	return node.N;
    }
    
    public void put(T key, V value){
	
	root = put(root, key, value);
	root.color = BLACK;
    }
    
    private Node put(Node node, T key, V value){
	
	if(node == null) return new Node(key, value, 1, RED);
	
	int result = key.compareTo(node.key);
	
	if(result < 0) node.left = put(node.left, key, value);
	else if(result > 0) node.right = put(node.right, key, value);
	else node.value = value;
	
	if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
	if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
	if(isRed(node.left) && isRed(node.right)) flipColors(node);
	
	node.N = size(node.left) + size(node.right) + 1;
	return node;
    }
    
    public void remove(T key){
	
	// TODO needs to be implemented
    }
    
    public V get(T key){
	
	return get(root, key);
    }
    
    private V get(Node node, T key){
	
	int result = node.key.compareTo(key);
	
	if(result == 0) return node.value;
	else if(result < 0) return get(node.left, key);
	else if(result > 0) return get(node.right, key);
	
	else return null;	
    }
}