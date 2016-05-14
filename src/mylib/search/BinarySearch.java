package mylib.search;

public class BinarySearch{

    public static <T extends Comparable<? super T>> T binarySearch(T[] array, T key){

	int low = 0;
	int high = array.length - 1;

	while (low <= high){

	    int mid = low + (high - low) / 2;
	    int result = array[mid].compareTo(key);

	    if (result == 0)
		return array[mid];
	    
	    else if (result > 0)
		high = mid - 1;

	    else if (result < 0){

		low = mid + 1;
	    }
	}

	return null;	    	
    }
}
