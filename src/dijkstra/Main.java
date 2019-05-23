package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		// this input is for directed graph try to do undirected by your self. 
		
		graph(new int[][] { { 2, 1, 1 }, { 2, 3, 5 }, { 3, 4, 1 }, { 4, 2, 1 }, { 1, 4, 1 } }, 4, 2);
		
		/*		
		 * 		following picture represent the above graph. 		
		 * 
		 * 				1	
		 * 		2----------->1
		 *		|^			 |
		 *		| \			 |
		 *	5	|  \		 |1
		 *		|	\		 | 
		 * 		|	 \	1	 |
		 * 		|	  \		 |
		 * 		|	   \	 | 
		 * 		|	    \	 |
		 * 		|	  	 \	 |
		 * 		|	      \	 |
		 * 	   \|/	       \\|/
		 * 		3----------->4
		 * 				1
		 * */

	}

	public static int dist[];
	public static List<node> adj[];

	@SuppressWarnings("unchecked")
	public static void graph(int[][] times, int N, int K) {

		System.out.println("Number Of nodes: " + N);
		System.out.println("Source Vertex: " + K);

		adj = (List<node>[]) new List[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, 500);

		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int[] t : times) {
			int src = t[0], dst = t[1], w = t[2];
			adj[src].add(new node(dst, w));
		}

		dijkstra(K, N);

		for (int i = 1; i <= N; i++)
			System.out.println(i + " -> " + dist[i]);

	}

	public static void dijkstra(int src, int N) {

		Set<Integer> visited = new HashSet<>();
		PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> (b.w - a.w));
		pq.add(new node(src, 0));
		dist[src] = 0;

		while (!pq.isEmpty()) {

			node n = pq.poll();
			int u = n.u;
			visited.add(u);

			for (node i : adj[u]) {

				int v = i.u;

				if (dist[u] + i.w < dist[v]) {
					dist[v] = dist[u] + i.w;
					pq.add(new node(v, dist[v]));
				}

			}

		}

	}

	public static class node {
		int u, w;

		public node(int u, int w) {
			this.u = u;
			this.w = w;
		}
	}

}
