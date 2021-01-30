package lessons.algo_ds.graph;

import java.util.LinkedList;

/**
 * 先从图中, 找出一个入度为0的顶点, 将其输出到拓扑排序的结果序列中(对应代码中就是把它打印出来),
 * 并且把这个顶点从图中删除(也就是把这个顶点可达的入度都减1).
 * 循环执行上面的过程, 直到所有的顶点都被输出. 最后输出的序列, 就是满足局部依赖关系的拓扑排序.
 */
public class TopoSortByKahn {
	private int v; //顶点个数
	private LinkedList<Integer>[] adj; //邻接表

	public void topoSortBuKahn() {
		int[] inDegree = new int[v]; //统计每个顶点的入度
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int w = adj[i].get(j);
				inDegree[w]++;
			}
		}

		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}

		while (!queue.isEmpty()) {
			int i = queue.remove();
			System.out.println("->" + i);
			for (int j = 0; j < adj[i].size(); j++) {
				int k = adj[i].get(j);
				inDegree[k]--;
				if (inDegree[k] == 0) queue.add(k);
			}
		}
	}

}
