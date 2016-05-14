package mylib.sort;

public class BubbleSort{

    public static int[] bubbleSort(int[] array){

	for (int i = array.length - 1; i >= 0; i--){
	    for (int j = 0; j <= i - 1; j++){

		if (array[j] > array[j + 1]){

		    int temp = array[j];
		    array[j] = array[j + 1];
		    array[j + 1] = temp;
		}
	    }
	}

	return array;
    }

    public static void main(String[] args){

	int[] a = {34, 7865, 124, 98, 2349, 982347234, 234, 456, 123, 2345, 245,
		7, 9276, 8192363};

	a = bubbleSort(a);

	for (int i : a)
	    System.out.print(i + ", ");
    }
}
