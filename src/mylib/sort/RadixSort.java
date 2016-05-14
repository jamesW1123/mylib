package mylib.sort;

import java.util.Arrays;

public class RadixSort{

    public static int[] sort(int[] array){

	int max = getMax(array);
	
	for (int i = 1; max / i > 0; i *= 10)
	    array = CountingSort.countingSort(array, i);

	return array;
    }    
   
    private static int getMax(int[] a){

	int max = 0;

	for (int i : a)
	    if (i > max) max = i;

	return max;
    }
    
    public static void main(String[] args){
	
	int[] a = {34, 7865, 124, 98, 2349, 982347234, 234, 456, 123,
		2345, 245, 7, 9276, 8192363};
	
	a = sort(a);
	
	for(int i : a)
	    System.out.print(i + ", ");
	
    }    
}
