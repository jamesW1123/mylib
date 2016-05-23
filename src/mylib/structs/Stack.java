package mylib.structs;

public class Stack<T> {

    private Node<T>[] nodes;
    private int	      count;
    private int	      top;

    @SuppressWarnings("unchecked")
    public Stack(){

	nodes = new Node[2];
	nodes[0] = null;
	count = 0;
	top = 1;
    }

    public void push(T value){

	if (top > nodes.length - 1) resize(nodes.length * 2);

	nodes[top] = new Node<T>(value);
	count++;
	top++;
    }

    public T pop(){

	if (isEmpty()) return null;

	top--;
	T temp = nodes[top].getValue();
	nodes[top] = null;
	count--;

	if (top < nodes.length / 2) resize(nodes.length / 2);

	return temp;
    }

    public T peek(){

	return nodes[top - 1].getValue();
    }

    public boolean isEmpty(){

	return count == 0;
    }

    public int size(){

	return count;
    }

    private void resize(int newSize){

	@SuppressWarnings("unchecked")
	Node<T>[] temp = new Node[newSize];
	int length = newSize;

	if (nodes.length < newSize) length = nodes.length;

	for (int i = 0; i < length; i++)
	    temp[i] = nodes[i];

	nodes = temp;
    }

    @SuppressWarnings("hiding")
    private class Node<T> {

	private T value;

	public Node(T value){
	    this.value = value;
	}

	public T getValue(){

	    return value;
	}
    }
    
    public static void main(String[] args){
	
	String[] s = {".", "last", "be ", "should ", "This "};
	
	Stack<String> stack = new Stack<String>();
	
	for(String n : s)
	    stack.push(n);
	
	while(!stack.isEmpty())
	    System.out.print(stack.pop());
    }
}













