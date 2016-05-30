package mylib.sort;

public class ShellSort{

    public static void sort(int[] array){

	int N = array.length;
	int i = 1;

	while (i < N / 3)
	    i = 3 * i + 1;

	while (i >= 1){

	    for (int j = i; j < N; j++){
		for (int k = j; k >= i && array[k] < array[k - i]; k -= i)
		    swap(array, k, k - i);
	    }

	    i = i / 3;
	}
    }

    private static void swap(int[] array, int x, int y){

	int temp = array[x];
	array[x] = array[y];
	array[y] = temp;
    }

    public static void main(String[] args){

	int[] a = {34, 7865, 124, 98, 2349, 982347234, 234, 456, 123, 2345, 245,
		7, 9276, 8192363};

	sort(a);

	for (int i : a)
	    System.out.print(i + ", ");
    }
}
