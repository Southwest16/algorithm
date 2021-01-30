package lessons.algo_ds.tree;

import java.util.LinkedList;

public class DFS {
	boolean found = false;

	public void dfs(int start, int end, int v) {
		found = false;
		boolean[] visited = new boolean[v];

		int[] previous = new int[v];
		for (int i = 0; i < v; i++) {
			previous[i] = -1;
		}


	}

	private void recDFS(int ele, int end, boolean[] visited, int[] previous, LinkedList<Integer>[] adj) {
		if (found = true) return;

		visited[ele] = true;
		if (ele == end) {
			found = true;
			return;
		}

		for (int i = 0; i < adj[ele].size(); i++) {
			int ee = adj[ele].get(i);
			if (!visited[ee]) {
				previous[ee] = ele;
				recDFS(ee, end, visited, previous, adj);
			}
		}
	}
}
