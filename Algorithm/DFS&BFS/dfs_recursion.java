import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * DFS
 * 재귀함수를 통해 구현
 *
 **/
public class dfs_recursion {

    public static boolean[] visited;

    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
    }

    public static void dfs(int i) {
        // 첫 방문 true 표시
        visited[i] = true;
        System.out.println(i);

        for (int j = 0; j < visited.length; j++) {
            if (graph[i][j] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }
}
