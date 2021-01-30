package lessons.algo_ds.graph;

import java.util.LinkedList;

/**
 * 图的实现
 *
 */
public class Graph {
	private int v; //顶点个数
	private LinkedList<Integer>[] adj; //邻接表

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	//无向图的一条边存两次
	public void addEdge(int from, int to) {
		adj[from].add(to);
		adj[to].add(from);
	}
}
