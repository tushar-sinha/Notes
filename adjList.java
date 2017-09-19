import java.io.*;
import java.util.*;

class adjList{
	static class graph{
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
		//g.adj[v].add(u);//since graph is undirected
	}
	static void printGraph(graph g){
		for(int v = 0; v < g.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: g.adj[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
	}
	static void BFS(int s, graph g){
		boolean[] visited = new boolean[g.V];
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		while(!q.isEmpty()){
			int v = q.poll();
			System.out.print(v+" -> ");
			Iterator<Integer> i = g.adj[v].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					q.offer(n);
				}
			}
		}
	}
	static void DFS(int s, graph g)
	{
		boolean[] visited = new boolean[g.V];
		DFSUtil(s,visited,g);
	}
	static void DFSUtil(int s, boolean[] visited, graph g){
		visited[s] = true;
		System.out.print(s+" -> ");
		Iterator<Integer> i = g.adj[s].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n]){
				DFSUtil(n,visited,g);
			}
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
        printGraph(g);
        System.out.println("BFS for tree :");
        BFS(0,g);
        System.out.println("\nDFS for tree :");
        DFS(0,g);
    }
}