package mylib.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph{

    private int			  V;
    private int			  E;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v){

	this.V = v;
	adj = (LinkedList<Integer>[]) new LinkedList[V];

	for (int i = 0; i < V; i++)
	    adj[i] = new LinkedList<Integer>();
    }

    @SuppressWarnings("unchecked")
    public Graph(File file){

	try{

	    Scanner in = new Scanner(file);

	    this.V = Integer.parseInt(in.nextLine());
	    this.E = Integer.parseInt(in.nextLine());

	    adj = (LinkedList<Integer>[]) new LinkedList[V];

	    for (int i = 0; i < V; i++)
		adj[i] = new LinkedList<Integer>();

	    while (in.hasNext()){

		String s = in.nextLine();
		String[] a = s.split(" ");

		int v = Integer.parseInt(a[0]);
		int w = Integer.parseInt(a[1]);

		addEdge(v, w);
	    }

	    in.close();
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    e.printStackTrace();
	}
    }

    public int getV(){

	return V;
    }

    public int getE(){

	return E;
    }

    public Iterable<Integer> getAdj(int v){

	return adj[v];
    }

    public void addEdge(int v, int w){

	adj[v].add(w);
    }
}
