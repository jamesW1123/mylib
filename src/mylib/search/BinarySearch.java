package mylib.search;

import java.util.Comparator;

public class BinarySearch{

    public static <T> T binarySearch(T[] array, T key, Comparator<T> comparator){

	// Initialize variables
	int low = 0;
	int high = array.length - 1;

	// while low <= high
	while (low <= high){

	    // Set mid
	    int mid = low + (high - low) / 2;

	    // Compare the middle element with the key
	    int result = comparator.compare(array[mid], key);

	    // If the mid element matches the key
	    if (result == 0){

		return array[mid];

	    }
	    // If the middle element is greater than the key
	    else if (result > 0){

		high = mid - 1;
	    }
	    // If the middle element is less than the key
	    else if (result < 0){

		low = mid + 1;
	    }
	}

	// Key not found
	return null;	    	
    }

}
