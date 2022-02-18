import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 *
 * DFS
 * 스택을 통해 dfs 구현
 *
 **/
public class dsf_stack {

    public static boolean[] visited;

    public static int[][] graph;

    public static Stack<Integer> stack = new Stack<>();

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

        // 시작 노드 스택에 넣기
        stack.push(1);
        // 시작 노드 방문처리
        visited[1] = true;

        // 스택이 비어있지 않으면 계속 반복
        while (!stack.isEmpty()) {

            // 스택에서 하나 꺼내기
            int nodeIdx = stack.pop();
            System.out.println(nodeIdx);

            // 스택에서 꺼낸 노드와 인접한 노드 찾기
            for (int linkedNode : graph[nodeIdx]) {
                // 인접한 노드를 방문하지 않았을 경우 스택에 넣고 방문처리
                if (!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }

}
