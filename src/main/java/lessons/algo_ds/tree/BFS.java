package lessons.algo_ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的广度优先搜索实现
 */
public class BFS {
	public void bfs(int v, int start, int end, LinkedList<Integer>[] adj) {
		if (start == end) return;

		//用来存储已经被访问、但相连的顶点还没被访问的那些顶点
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		//用来存储已经被访问过的顶点, 避免重复访问
		boolean[] visited = new boolean[v];
		visited[start] = true;

		//用来存储搜索路径上的顶点
		int[] previous = new int[v];
		for (int i = 0; i < v; i++) {
			previous[i] = -1;
		}

		while (queue.size() != 0) {
			int e = queue.poll(); //获取并移除队头元素
			for (int i = 0; i < adj[e].size(); i++) {
				int ee = adj[e].get(i);
				if (!visited[ee]) {
					previous[ee] = e;
					if (ee == end) {
						return;
					}
					visited[ee] = true;
					queue.add(ee);
				}
			}
		}
	}
}
