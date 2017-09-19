import java.io.*;
import java.util.*;

class adjList{
	class graph{
		int V;
		LinkedList<Integer> adj[];
		graph(int v){
			this.V = v;

			adj = new LinkedList[v];
			for(int i = 0;i<V;i++)
			{
				adj[i] = new LinkedList<>();
			}
		}
	}
	static void addEdge(graph g, int u, int v){
		g.adj[u].add(v);
		g.adj[v].add(u);//since graph is undirected
	}
	static void printGraph(graph g){
		for(int i = 0; i<g.V; i++){
			Iterator i = g.adj[i].listIterator();
			while(i.hasNext()){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	  public static void main(String args[])
    {
        // create the graph given in above figure
        int V = 5;
        graph g = new graph(V);
        addEdge(g, 0, 1);
        addEdge(g, 0, 4);
        addEdge(g, 1, 2);
        addEdge(g, 1, 3);
        addEdge(g, 1, 4);
        addEdge(g, 2, 3);
        addEdge(g, 3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        printGraph(graph);
    }
}