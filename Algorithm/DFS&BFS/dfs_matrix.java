import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 *
 * DFS
 * 재귀함수를 통해 구현
 *
 **/
public class dfs_matrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n];
        int[][] graph = new int[n][n];

        // 인접 행렬로 구현
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs_recursion(0, graph, visited);
    }

    // dfs 재귀
    public static void dfs_recursion(int v, int[][] graph, boolean[] visited) {
        // 첫 방문 true 표시
        visited[v] = true;
        System.out.println(v);

        for (int j = 0; j < visited.length; j++) {
            if (graph[v][j] == 1 && visited[j] == false) {
                dfs_recursion(j, graph, visited);
            }
        }
    }

    // dfs 스택
    public static void dfs_stack(int v, int[][] graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        System.out.println(v);

        while (!stack.isEmpty()) {

            // 스택에서 하나 꺼내기
            int nodeIdx = stack.pop();
            System.out.println(nodeIdx);

            // 스택에서 꺼낸 노드와 인접한 노드 찾기
            for (int linkedNode : graph[v]) {
                if (!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }


        }
    }
}
// https://minhamina.tistory.com/22
