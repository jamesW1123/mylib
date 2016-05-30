package mylib.structs;

public class UnionFind{

    private int[] id;

    public UnionFind(int n){

	id = new int[n];

	for(int i = 0; i < id.length; i++)
	    id[i] = i;
    }

    public boolean isConnected(int x, int y){
	return id[x] == id[y];
    }

    public int find(int x){
	return id[x];
    }

    public void union(int x, int y){

	int xParent = find(x);
	int yParent = find(y);

	if(xParent == yParent) return;

	for(int i = 0; i < id.length; i++)
	    if(id[i] == xParent)
		id[i] = yParent;			
    }

    public void print(){

	for(int i : id)
	    System.out.print(i + ", ");
    }

    public static void main(String[] args){

	int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	UnionFind u = new UnionFind(a.length);

	u.print();
	System.out.println();

	u.union(3, 6);
	u.print();
	System.out.println();	    
	u.union(2, 4);
	u.print();
	System.out.println();
	u.union(4, 1);
	u.print();
	System.out.println();
	u.union(8, 3);
	u.print();
	System.out.println();
	u.union(9, 7);
	u.print();
	System.out.println();
	u.union(7, 1);
	u.print();
	System.out.println();
    }

}



















