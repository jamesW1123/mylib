package mylib.structs;

public class MaxHeap{

    private int		    count;
    private Node<Integer>[] heap;

    @SuppressWarnings("unchecked")
    public MaxHeap(){

	heap = new Node[1];
	heap[0] = new Node<Integer>(null);
    }

    public void insert(int value){

	if (count + 1 > heap.length - 1) resize(heap.length * 2);

	count++;
	heap[count] = new Node<Integer>(value);

	swim();
    }

    public int getMax(){

	Node<Integer> temp = heap[1];
	heap[1] = heap[count];
	heap[count] = null;
	count--;
	sink();

	if (count < heap.length / 2) resize(heap.length / 2);

	return temp.getValue();
    }

    public int peek(){

	return heap[1].getValue();
    }

    private void sink(){

	int index = 1;

	while (index < count - 1){

	    int leftChild = index * 2;
	    int rightChild = index * 2 + 1;

	    if (leftChild > count) break;
	    int maxIndex = leftChild;

	    if (rightChild <= count){

		if (heap[maxIndex].getValue() < heap[rightChild].getValue())
		    maxIndex = rightChild;
	    }

	    if (heap[index].getValue() < heap[maxIndex].getValue()){

		Node<Integer> temp = heap[index];
		heap[index] = heap[maxIndex];
		heap[maxIndex] = temp;
		index = maxIndex;
	    }
	    else break;
	}
    }

    private void swim(){

	int index = count;

	while (index >= 0){

	    int parentIndex = index / 2;

	    if (parentIndex < 1) break;

	    if (heap[index].getValue() > heap[parentIndex].getValue()){

		Node<Integer> temp = heap[index];
		heap[index] = heap[parentIndex];
		heap[parentIndex] = temp;
		index = parentIndex;
	    }
	    else break;
	}
    }

    public int size(){

	return count;
    }

    public boolean isEmpty(){

	return count == 0;
    }

    public void printHeap(){

	System.out.print(heap[1].getValue());

	for (int i = 2; i <= count; i++)
	    System.out.print(", " + heap[i].getValue());
	System.out.println();
    }

    private void resize(int newSize){

	@SuppressWarnings("unchecked")
	Node<Integer>[] temp = new Node[newSize];

	int length = 0;

	if (heap.length < temp.length) length = heap.length;
	else length = temp.length;

	for (int i = 0; i < length; i++)
	    temp[i] = heap[i];

	heap = temp;
    }

    private class Node<T extends Comparable<? super T>> {

	private T value;

	public Node(T value){
	    this.value = value;
	}

	public T getValue(){

	    return value;
	}
    }
}
