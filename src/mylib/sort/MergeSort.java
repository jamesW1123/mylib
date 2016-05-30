package mylib.sort;

public class MergeSort{

    private static int[] temp;

    public static void sortTD(int[] array){

	temp = new int[array.length];

	sortTD(array, 0, array.length - 1);
    }

    public static void sortTD(int[] array, int low, int high){

	if (high <= low) return;

	int mid = low + (high - low) / 2;

	sortTD(array, low, mid);
	sortTD(array, mid + 1, high);
	merge(array, low, mid, high);
    }

    public static void sortBU(int[] array){

	temp = new int[array.length];

	for (int i = 1; i < array.length; i *= 2){
	    for (int low = 0; low < array.length - i; low += 2 * i)
		merge(array, low, low + i - 1,
			Math.min(low + 2 * i - 1, array.length - 1));
	}
    }

    private static void merge(int[] array, int low, int mid, int high){

	int i = low;
	int j = mid + 1;

	for (int k = low; k <= high; k++)
	    temp[k] = array[k];

	for (int k = low; k <= high; k++){

	    if (i > mid) array[k] = temp[j++];
	    else if (j > high) array[k] = temp[i++];
	    else if (temp[j] < temp[i]) array[k] = temp[j++];
	    else array[k] = temp[i++];
	}
    }

    public static void main(String[] args){

	int[] a = {34, 7865, 124, 98, 2349, 982347234, 234, 456, 123, 2345, 245,
		7, 9276, 8192363};

	// sortTD(a);
	sortBU(a);

	for (int i : a)
	    System.out.print(i + ", ");
    }

}
