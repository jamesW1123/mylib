package mylib.structs;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int	    count;

    public LinkedList(){

	first = new Node<T>(null);
	last = new Node<T>(null);
	first.setNext(last);
	count = 0;
    }

    public boolean add(T value){

	if (isEmpty()){
	    first.setValue(value);
	    count++;
	    return true;
	}
	else if (!contains(value)){
	    last.setValue(value);
	    last.setNext(new Node<T>(null));
	    last = last.getNext();
	    count++;
	    return true;
	}

	return false;
    }

    public boolean addAll(T[] array){

	boolean added = false;

	for (T e : array)
	    added = add(e);

	return added;
    }

    public T getFirst(){

	return first.getValue();
    }

    public Node<T> first(){

	return this.first;
    }

    public T getLast(){

	return last.getValue();
    }

    public Node<T> last(){

	return this.last;
    }

    public boolean contains(T key){

	Node<T> current = first;

	while (current.getValue() != null){

	    if (current.getValue().compareTo(key) == 0) return true;
	    else current = current.getNext();
	}

	return false;
    }

    public boolean remove(T key){

	Node<T> current = first;
	Node<T> previous = new Node<T>(null);

	while (current.getNext() != null){

	    if (current.getValue().compareTo(key) == 0){

		if (current == first) first = first.getNext();
		else previous.setNext(current.getNext());
		count--;
		return true;
	    }
	    else{
		previous = current;
		current = current.getNext();
	    }
	}

	return false;
    }

    public boolean removeAll(LinkedList<T> list){

	Node<T> current = list.first();
	boolean removed = false;

	while (current.getValue() != null){

	    if (contains(current.getValue())){

		remove(current.getValue());
		removed = true;
	    }

	    current = current.getNext();
	}

	return removed;
    }

    public boolean retainAll(LinkedList<T> list){

	Node<T> current = this.first();
	Stack<T> stack = new Stack<T>();
	boolean removed = false;

	while (current.getValue() != null){

	    if (list.contains(current.getValue())){
	    }
	    else stack.push(current.getValue());

	    current = current.getNext();
	}

	while (!stack.isEmpty())
	    removed = this.remove(stack.pop());

	return removed;
    }

    public boolean isEmpty(){

	return count == 0;
    }

    public int size(){

	return count;
    }
    
    @Override
    public Iterator<T> iterator(){

	// TODO Auto-generated method stub
	return null;
    }

    public void iterate(){

	Node<T> current = first;

	while (current.getValue() != null){

	    System.out.println(current.getValue());
	    current = current.getNext();
	}
    }

    public static void main(String[] args){

	LinkedList<String> list1 = new LinkedList<String>();
	LinkedList<String> list2 = new LinkedList<String>();
	LinkedList<Integer> list3 = new LinkedList<Integer>();
	LinkedList<Integer> list4 = new LinkedList<Integer>();

	String[] a = {"This ", "should ", "be ", "should ", "correct", "."};
	String[] b = {"should ", "."};
	Integer[] c = {23, 56, 76, 654, 87677};
	Integer[] d = {45, 78, 54, 56, 23, 768};

	System.out.println("Running...");

	list1.addAll(a);
	list2.addAll(b);

	list1.iterate();
	list2.iterate();
	list1.removeAll(list2);
	// list1.retainAll(list2);
	list1.iterate();
	list2.iterate();

	list3.addAll(c);
	list4.addAll(d);

	list3.iterate();
	list4.iterate();
	// list3.removeAll(list4);
	list4.retainAll(list3);
	list3.iterate();
	list4.iterate();

    }   
}
