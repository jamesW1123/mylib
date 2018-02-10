package mylib.sort;

import java.util.Collections;
import java.util.Vector;

public class BucketSort<T extends Comparable<T>>{

    public static int[] bucketSort(int[] array){
	
	@SuppressWarnings("unchecked")
	Vector<Integer>[] buckets = new Vector[array.length];
	
	for(int i = 0; i < buckets.length; i++){
	    buckets[i] = new Vector<Integer>();
	}

	for(Integer current: array){

	    int index = Integer.numberOfLeadingZeros(current) % array.length;
	    buckets[index].add(current);	
	}
	
	
	Vector<Integer> rst = new Vector<Integer>();
	
	for(int i = 0; i < buckets.length; i++){
	    
	    Collections.sort(buckets[i]);
	    rst.addAll(buckets[i]);
	}
	
	Object[] tmp = new Integer[rst.size()];
	tmp = rst.toArray();
	int[] finalResult = new int[tmp.length];
	
	for(int i = 0; i < tmp.length; i++){
	    finalResult[i] = (int) tmp[i];
	}
	
	MergeSort.sortBU(finalResult);

	System.out.println("final Result:");

	for(int i: finalResult)
	    System.out.println(i);
	


	return finalResult;
    }

    public static void main(String[] args){

	int[] a = {100, 223, 713, 46, 52, 627, 33, 835};
	
	a = bucketSort(a);
    }
}
















