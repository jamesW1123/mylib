package mylib.sort;

public class CountingSort{

    public static int[] countingSort(int[] array){

	int k = getMax(array);
	int[] count = new int[k + 1];
	int[] result = new int[array.length + 1];

	for (int i = 0; i < array.length; i++)
	    count[array[i]] = count[array[i]] + 1;

	for (int i = 1; i < k + 1; i++)
	    count[i] += count[i - 1];

	for (int i = 0; i < array.length; i++){

	    result[count[array[i]]] = array[i];
	    count[array[i]] = count[array[i]] - 1;
	}

	return result;
    }

    public static int[] countingSort(int[] array, int place){

	int[] count = new int[10];
	int[] result = new int[array.length];

	for (int i = 0; i < count.length; i++)
	    count[i] = 0;

	for (int i = 0; i < array.length; i++)
	    count[(array[i] / place) % 10]++;
	
	for (int i = 1; i < 10; i++)
	    count[i] += count[i - 1];

	for (int i = array.length - 1; i >= 0; i--){

	    result[count[ (array[i]/place)%10 ] - 1] = array[i];
	    count[ (array[i]/place)%10 ]--;
	}

	int[] output = new int[array.length];
	
	for(int i = 0; i < array.length; i++)
	    output[i] = result[i];
	
	return output;
    }

    private static int getMax(int[] a){

	int max = 0;

	for (int i : a)
	    if (i > max) max = i;

	return max;
    }
}
