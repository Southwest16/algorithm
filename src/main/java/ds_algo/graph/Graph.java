package ds_algo.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;//顶点个数
    private LinkedList<Integer> adj[];//邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {//无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    //广度优先搜索
    public void bfs(int start, int end) {
        if (start == end) return;

        boolean[] visited = new boolean[v];//用来存储已被访问的顶点,避免被重复访问
        Queue<Integer> queue = new LinkedList<>();//用来存储已经被访问、但相邻顶点还没被访问的顶点
        visited[start] = true;
        queue.add(start);

        //用来记录搜索路径, 不过这个路径是反向存储的。
        //prew[w]存储的是, 顶点w是从哪个前驱顶点遍历过来的。
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();//获取并移除队列头部元素
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == end) {
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    //深度优先搜索
    boolean found = false;
    public void dfs(int start, int end) {
        found = false;
        boolean[] visited = new boolean[v];

        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(start, end, visited, prev);
    }

    private void recurDfs(int w, int end, boolean[] visited, int[] prev) {
        if (found = false) return;

        visited[w] = true;
        if (w == end) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, end, visited, prev);
            }
        }
    }
}
