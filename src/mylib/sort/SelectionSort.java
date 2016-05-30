package mylib.sort;

public class SelectionSort{
    
    public static void sort(int[] array){	
	
	for(int i = 0; i < array.length; i++){
	    
	    int min = i;
	    
	    for(int j = i+1; j < array.length; j++)
		if(array[j] < array[min]) min = j;
	    	    
	    if(min != i)
		swap(array, i, min);
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













