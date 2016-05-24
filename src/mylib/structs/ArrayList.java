package mylib.structs;

public class ArrayList<T extends Comparable<T>> {

    private Node<T>[] elements;
    private int	      last;
    private int	      count;

    @SuppressWarnings("unchecked")
    public ArrayList(){

	elements = new Node[1];
	elements[0] = new Node<T>(null);
	last = 0;
	count = 0;
    }

    public boolean add(T value){

	if (last >= elements.length - 1) resize(elements.length * 2);

	if (!contains(value)){

	    elements[last].setValue(value);
	    count++;
	    last++;
	    return true;
	}

	return false;
    }

    public boolean addAll(T[] array){

	for (T value : array)
	    add(value);

	return false;
    }

    public boolean addAll(ArrayList<T> list){

	for(int i = 0; i < list.size(); i++)
		this.add(list.getElementAt(i));
	
	return false;
    }

    public boolean addAll(LinkedList<T> list){

	Node<T> current = list.first();
	boolean changed = false;
	
	while(current.getNext() != null){
	    
	    if(!changed)
	    changed = this.add(current.getValue());
	    
	    else this.add(current.getValue());
	    
	    current = current.getNext();
	}
	
	return changed;
    }

    public boolean removeElement(T key){

	int index = findIndex(key);

	if (index >= 0) return removeElementAt(index);

	return false;
    }

    public boolean removeElementAt(int index){

	@SuppressWarnings("unchecked")
	Node<T>[] temp = new Node[elements.length];
	int current = 0;
	boolean removed = false;

	for (int i = 0; i < elements.length; i++){

	    if (i != index){

		temp[current] = elements[i];
		current++;

	    }
	    else{
		removed = true;
		count--;
		last--;
	    }
	}

	elements = temp;

	return removed;
    }

    public boolean retainAll(ArrayList<T> list){
	
	Stack<T> stack = new Stack<T>();
	
	for(int i = 0; i < this.size(); i++){
	    if(!list.contains(this.getElementAt(i))){
		stack.push(this.getElementAt(i));
	    }
	}
	
	while(!stack.isEmpty())
	    this.removeElement(stack.pop());
	
	return false;
    }
    
    public boolean removeAll(ArrayList<T> list){
	
	for(int i = 0; i < list.size(); i++)
	    if(this.contains(list.getElementAt(i)))
		this.removeElement(list.getElementAt(i));
	
	return false;
    }
    
    public T getElementAt(int index){	
	return elements[index].getValue();
    }
    
    private int findIndex(T key){

	for (int i = 0; i < last; i++)
	    if (elements[i].getValue().compareTo(key) == 0) return i;

	return -1;
    }

    public boolean contains(T key){

	for (int i = 0; i < count; i++)
	    if (elements[i].getValue().compareTo(key) == 0) return true;

	return false;
    }
    
    public int size(){
	return this.count;
    }

    private void resize(int newSize){

	@SuppressWarnings("unchecked")
	Node<T>[] temp = new Node[newSize];

	for (int i = 0; i < last; i++)
	    temp[i] = elements[i];

	for (int i = last; i < temp.length; i++)
	    temp[i] = new Node<T>(null);

	elements = temp;
    }

    public void iterate(){

	for (int i = 0; i < count; i++)
	    System.out.println(elements[i].getValue());

    }

    public static void main(String[] args){

	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<Integer> list3 = new ArrayList<Integer>();
	ArrayList<Integer> list4 = new ArrayList<Integer>();

	LinkedList<String> llist = new LinkedList<String>();
	
	String[] a = {"This ", "should ", "be ", "should ", "correct", "."};
	String[] b = {"should ", ".", "and ", "this"};
	Integer[] c = {23, 56, 76, 654, 87677};
	Integer[] d = {45, 78, 54, 56, 23, 768};

	for (String s : a)
	    list1.add(s);

	//list2.addAll(b);
	list3.addAll(c);
	list4.addAll(d);
	
	llist.addAll(b);

	System.out.println("list1");
	list1.iterate();
	System.out.println("");
	list2.iterate();
	list1.addAll(llist);
	System.out.println("~~~~~~~~~~~~~~~~~~~~");
	list1.iterate();

	/*//list2.iterate();
	list3.iterate();
	list4.iterate();
	list3.removeAll(list4);
	list3.iterate();*/
	
	
    }

}
