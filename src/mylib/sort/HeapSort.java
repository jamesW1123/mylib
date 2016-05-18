package mylib.sort;

import mylib.structs.MaxHeap;
import mylib.structs.MinHeap;

public class HeapSort{

    public static void ascendingSort(int[] array)
	    throws IndexOutOfBoundsException{

	MinHeap heap = new MinHeap();

	for (int i : array)
	    heap.insert(i);

	for (int i = 0; i < array.length; i++)
	    array[i] = heap.getMin();

	if (!heap.isEmpty()) throw new IndexOutOfBoundsException(
		"Something went terribly, terribly wrong!");
    }

    public static void descendingSort(int[] array)
	    throws IndexOutOfBoundsException{

	MaxHeap heap = new MaxHeap();

	for (int i : array)
	    heap.insert(i);

	for (int i = 0; i < array.length; i++)
	    array[i] = heap.getMax();

	if (!heap.isEmpty()) throw new IndexOutOfBoundsException(
		"Something went terribly, terribly wrong!");
    }

    public static void main(String[] args){

	int[] a = {34, 765, 87, 23, 65, 98, 546};

	ascendingSort(a);
	for (int i : a)
	    System.out.print(i + ", ");
	System.out.println();

	int[] b = {34, 765, 87, 23, 65, 98, 546};

	descendingSort(b);
	for (int i : b)
	    System.out.print(i + ", ");
	System.out.println();
    }
}
