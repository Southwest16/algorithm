package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v; //顶点的个数
    private LinkedList<Integer> adj[]; //邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) { //无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    //广度优先搜索
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v]; //用来记录已经被访问的顶点，避免顶点被重复访问
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>(); //用来存储已经被访问、但相连的顶点还没被访问的顶点
        queue.add(s);
        int[] prev = new int[v]; //用来记录搜索路径，这个路径是反向存储的
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t!= s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + "");
    }


    boolean found = false;
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found = true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
