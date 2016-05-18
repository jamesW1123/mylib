package mylib.structs;

public class MinHeap{

    private int		    count;
    private Node<Integer>[] heap;

    @SuppressWarnings("unchecked")
    public MinHeap(){

	heap = new Node[1];
	heap[0] = new Node<Integer>(null);
    }

    public void insert(int value){

	if (count + 1 > heap.length - 1) resize(heap.length * 2);

	count++;
	heap[count] = new Node<Integer>(value);

	swim();
    }

    public int getMin(){

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
	    int minIndex = leftChild;

	    if (rightChild <= count){

		if (heap[minIndex].getValue() > heap[rightChild].getValue())
		    minIndex = rightChild;
	    }

	    if (heap[index].getValue() > heap[minIndex].getValue()){

		Node<Integer> temp = heap[index];
		heap[index] = heap[minIndex];
		heap[minIndex] = temp;
		index = minIndex;
	    }
	    else break;
	}
    }

    private void swim(){

	int index = count;

	while (index >= 0){

	    int parentIndex = index / 2;

	    if (parentIndex < 1) break;

	    if (heap[index].getValue() < heap[parentIndex].getValue()){

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

	for (int i = 1; i <= count; i++)
	    System.out.print(heap[i].getValue() + ", ");
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
