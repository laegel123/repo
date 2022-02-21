import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * BOJ : DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 *
 **/
public class dfs_bfs01 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] graph = new int[nodeNum+1][nodeNum+1];
        boolean[] visited = new boolean[nodeNum + 1];

        // 인접행렬로 구현
        while (edgeNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            graph[i][j] = 1;
            graph[j][i] = 1;
        }

        dfs_recursion(v, graph, visited);
        sb.append("\n");
        visited = new boolean[nodeNum + 1];
        bfs_queue(v, graph, visited);

        System.out.println(sb);

    }

    public static void dfs_recursion(int v, int[][] graph, boolean[] visited) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i < visited.length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs_recursion(i, graph, visited);
            }

        }

    }

    public static void bfs_queue(int v, int[][] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        int n = visited.length;
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int newNode = q.poll();
            sb.append(newNode).append(" ");

            for (int i = 1; i < n; i++) {
                if (graph[newNode][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
