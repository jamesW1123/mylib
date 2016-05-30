package mylib.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KMPSearch{

    private char[]    t;
    private int	      N;
    private int[][]   dfa;
    private final int R	= 256;

    public KMPSearch(String text){

	t = text.toCharArray();
	N = t.length;
    }

    public int search(String pattern, int start){

	char[] p = pattern.toCharArray();
	int M = pattern.length();

	if (p.length != M) throw new IllegalArgumentException();

	int i, j = N;

	computeDFA(pattern);

	for (i = start, j = 0; i < N && j < M; i++)
	    j = dfa[t[i]][j];

	if (j == M) return i - M;
	else return N;
    }

    private void computeDFA(String pattern){

	char[] p = pattern.toCharArray();
	int M = pattern.length();
	if (p.length != M)
	    throw new IllegalArgumentException("lengths do not match");

	dfa = new int[R][M];
	dfa[p[0]][0] = 1;

	for (int i = 0, j = 1; j < M; j++){

	    for (int k = 0; k < R; k++)
		dfa[k][j] = dfa[k][i];
	    
	    dfa[p[j]][j] = j + 1;
	    i = dfa[p[j]][i];
	}
    }

    public static void main(String[] args){

	Scanner in = null;
	String text = "";

	try{
	    in = new Scanner(new File("res/standUp.txt"));
	}
	catch (FileNotFoundException e){
	    e.printStackTrace();
	}

	while (in.hasNext())
	    text += in.nextLine();

	String p = " Stand ";
	KMPSearch k = new KMPSearch(text);

	System.out.println("text length: " + text.length());

	System.out.println(k.search(p, 0));
	int index = k.search(p, 0);
	System.out.println(text.substring(index, index + p.length()));

	while (index != text.length()){

	    index = k.search(p, index + 1);

	    if (index + p.length() < text.length())
		System.out.println(text.substring(index, index + p.length()));
	}
    }
}
