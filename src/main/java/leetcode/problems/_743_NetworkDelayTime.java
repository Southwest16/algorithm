package leetcode.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/
 *
 *
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node,
 * and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K.
 * How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */
public class _743_NetworkDelayTime {

	// ##########################################################################################
	//Heap Implementation
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap();
		for (int[] edge : times) {
			if (!graph.containsKey(edge[0]))
				graph.put(edge[0], new ArrayList<int[]>());
			graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
		}
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
				(info1, info2) -> info1[0] - info2[0]);
		heap.offer(new int[]{0, K});

		Map<Integer, Integer> dist = new HashMap();

		while (!heap.isEmpty()) {
			int[] info = heap.poll();
			int d = info[0], node = info[1];
			if (dist.containsKey(node)) continue;
			dist.put(node, d);
			if (graph.containsKey(node))
				for (int[] edge : graph.get(node)) {
					int nei = edge[0], d2 = edge[1];
					if (!dist.containsKey(nei))
						heap.offer(new int[]{d + d2, nei});
				}
		}

		if (dist.size() != N) return -1;
		int ans = 0;
		for (int cand : dist.values())
			ans = Math.max(ans, cand);
		return ans;
	}


	// ###########################################################################################
	//Basic Implementation
	Map<Integer, Integer> dist;

	public int networkDelayTime2(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : times) {
			if (!graph.containsKey(edge[0]))
				graph.put(edge[0], new ArrayList<>());

			graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
		}

		dist = new HashMap<>();
		for (int node = 1; node <= N; node++) {
			dist.put(node, Integer.MAX_VALUE);
		}

		dist.put(K, 0);
		boolean[] seen = new boolean[N + 1];

		while (true) {
			int candNode = -1;
			int candDist = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				if (!seen[i] && dist.get(i) < candDist) {
					candDist = dist.get(i);
					candNode = i;
				}
			}

			if (candNode < 0) break;
			seen[candNode] = true;
			if (graph.containsKey(candNode)) {
				for (int[] info : graph.get(candNode)) {
					dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
				}
			}
		}

		int ans = 0;
		for (int cand : dist.values()) {
			if (cand == Integer.MAX_VALUE) return -1;
			ans = Math.max(ans, cand);
		}

		return ans;
	}


	// ###########################################################################################
	//Depth-First Search
	//Map<Integer, Integer> dist;
	public int networkDelayTime3(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap();
		for (int[] edge : times) {
			if (!graph.containsKey(edge[0]))
				graph.put(edge[0], new ArrayList<int[]>());
			graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
		}
		for (int node : graph.keySet()) {
			Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
		}
		dist = new HashMap();
		for (int node = 1; node <= N; ++node)
			dist.put(node, Integer.MAX_VALUE);

		dfs(graph, K, 0);
		int ans = 0;
		for (int cand : dist.values()) {
			if (cand == Integer.MAX_VALUE) return -1;
			ans = Math.max(ans, cand);
		}
		return ans;
	}

	public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
		if (elapsed >= dist.get(node)) return;
		dist.put(node, elapsed);
		if (graph.containsKey(node))
			for (int[] info : graph.get(node))
				dfs(graph, info[1], elapsed + info[0]);
	}
}
