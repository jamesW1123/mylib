package mylib.sort;

public class InsertionSort{

    public static void sort(int[] array){	
	
	for(int i = 1; i < array.length; i++){
	    for(int j = i; j > 0 && array[j] < array[j-1]; j--)
		swap(array, j, j-1);	   
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
