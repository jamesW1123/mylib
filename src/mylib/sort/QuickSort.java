package mylib.sort;

public class QuickSort{

    public static void sort(int[] array){

	sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high){

	if (high <= low) return;

	int i = partition(array, low, high);
	sort(array, low, i - 1);
	sort(array, i + 1, high);
    }

    private static int partition(int[] array, int low, int high){

	int i = low;
	int j = high + 1;
	int p = array[low];

	while (true){

	    while (array[++i] < p)
		if (i == high) break;
	    while (p < array[--j])
		if (j == low) break;

	    if (i >= j) break;
	    swap(array, i, j);
	}
	swap(array, low, j);
	return j;
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
