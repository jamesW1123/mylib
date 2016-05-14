package mylib.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

public class DFS{

    private Graph		 g;
    private int			 V;
    private boolean[]		 isMarked;
    private ArrayList<Integer>	 preOrder;
    private ArrayList<Integer>	 postOrder;
    private ArrayList<Integer>[] components;
    private Stack<Integer>	 stack;
    private static int		 componentCount;

    @SuppressWarnings("unused")
    public DFS(Graph g){

	this.g = g;
	V = g.getV();
	isMarked = new boolean[V];
	preOrder = new ArrayList<Integer>();
	postOrder = new ArrayList<Integer>();
	componentCount = 0;
	stack = new Stack<Integer>();
	stack.push(-1);

	for (boolean b : isMarked)
	    b = false;

	dfs();
    }

    @SuppressWarnings("unchecked")
    private void dfs(){

	for (int i = 0; i < V; i++){

	    if (!isMarked[i]){

		dfs(i);
		componentCount++;
		stack.push(-1);
	    }
	}

	stack.pop();
	components = (ArrayList<Integer>[]) new ArrayList[componentCount];
	int current = stack.pop();

	for (int i = 0; i < componentCount; i++){

	    components[i] = new ArrayList<Integer>();

	    while (current != -1 && !stack.isEmpty()){

		components[i].add(current);
		current = stack.pop();
	    }

	    if (!stack.isEmpty()) current = stack.pop();
	}
    }

    private void dfs(int v){

	isMarked[v] = true;
	stack.push(v);
	preOrder.add(v);

	for (int i : g.getAdj(v)){

	    if (!isMarked[i]) dfs(i);
	}

	postOrder.add(v);
    }

    public int getComponentCount(){

	return componentCount;
    }

    public void printComponents(){

	for (ArrayList<Integer> list : components)
	    System.out.println(list);
    }

    public ArrayList<Integer> getPreOrder(){

	return preOrder;
    }

    public ArrayList<Integer> getPostOrder(){

	return postOrder;
    }

    public static void main(String[] args){

	Graph gr = new Graph(new File("res/mediumG.txt"));
	DFS d = new DFS(gr);

	System.out.println("# components: " + d.getComponentCount());
	d.printComponents();
	System.out.println("preOrder: " + d.getPreOrder());
	System.out.println("postOrder: " + d.getPostOrder());
    }
}
