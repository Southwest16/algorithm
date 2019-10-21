package problems;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private int n = 10;
	private LinkedList<Integer> table[];
	
	public void bfs(int start, int end) {
		if (start == end) return;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		boolean[] visited = new boolean[n];
		visited[start]=true;

		int[] prev = new int[n];
		for (int i = 0; i < n; ++i) {
			prev[i] = -1;
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int i = 0; i < table[curr].size(); ++i) {
				int q = table[curr].get(i);
				if (!visited[q]) {
					prev[q] = curr;
					if (q == end) {
						print(prev, start, end);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	private void print(int[] prev, int start, int end) { // 递归打印 start->end 的路径
		if (prev[end] != -1 && end != start) {
			print(prev, start, prev[end]);
		}
		System.out.print(end + " ");
	}

}
