package mylib.graph;

import java.io.File;

import mylib.structs.Queue;

public class BFS{

    private Graph     g;
    private boolean[] isMarked;

    public BFS(Graph g){

	this.g = g;
	isMarked = new boolean[g.getV()];

	bfs(0);

	for (int i = 0; i < g.getV(); i++){

	    System.out.println(i + ", " + isMarked[i]);
	}
    }

    private void bfs(int v){

	Queue<Integer> q = new Queue<Integer>();

	q.enqueue(v);

	while (!q.isEmpty()){

	    int current = q.dequeue();

	    if (!isMarked[current]){

		isMarked[current] = true;

		for (int i : g.getAdj(current))
		    q.enqueue(i);
	    }
	}
    }

    public static void main(String[] args){

	Graph gr = new Graph(new File("res/tinyDG.txt"));
	@SuppressWarnings("unused")
	BFS b = new BFS(gr);
    }

}
