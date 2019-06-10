package geektime_algorithm.Topo;

import java.util.LinkedList;

public class Graph {
    private int v;//顶点的个数
    private LinkedList<Integer> adj[];//邻接表


    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[v];//统计每个顶点的入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
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
