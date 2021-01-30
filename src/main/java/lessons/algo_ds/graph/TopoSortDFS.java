package lessons.algo_ds.graph;

import java.util.LinkedList;

/**
 * 第一部分是通过邻接表构造逆邻接表。邻接表中，边 s->t 表示 s 先于 t 执行，
 * 也就是 t 要依赖 s。在逆邻接表中，边 s->t 表示 s 依赖于 t，s 后于 t 执行。
 * 为什么这么转化呢？这个跟我们这个算法的实现思想有关。
 *
 * 第二部分是这个算法的核心，也就是递归处理每个顶点。对于顶点 vertex 来说，
 * 我们先输出它可达的所有顶点，也就是说，先把它依赖的所有的顶点输出了，然后再输出自己。
 */
public class TopoSortDFS {
	private int v; //顶点个数
	private LinkedList<Integer>[] adj; //邻接表

	public void topoSortByDFS() {
		//先构建逆邻接表, 边s->t表示, s依赖于t, t先于s
		LinkedList<Integer> inverseAdj[] = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			inverseAdj[i] = new LinkedList<>();
		}

		//通过邻接表生成逆邻接表
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int w = adj[i].get(j);
				inverseAdj[w].add(i);
			}
		}

		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (visited[i] = false) {
				visited[i] = true;
				dfs(i, inverseAdj, visited);
			}
		}
	}

	private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
		for (int i = 0; i < inverseAdj[vertex].size(); i++) {
			int w = inverseAdj[vertex].get(i);
			if (visited[w] == true) continue;
			visited[w] = true;
			dfs(w, inverseAdj, visited);
		}

		System.out.println("->" + vertex);
	}
}
