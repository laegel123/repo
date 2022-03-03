package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 숨바꼭질4
 * https://www.acmicpc.net/problem/13913
 * 주의 : 각 지점별로 경로를 저장하면 시간초과가 발생한다. (String을 더하면서 해결하려 했었다.)
 *      -> 알아보니 String 더하기의 경우 O(N+K)의 시간복잡도를 가진다. 그런데 while(!q.isEmpty)로 O(N)번 돌리면 최대 시간 복잡도는 O(N^2)으로 최대 10000000000*K 번 돌 수 있으므로
 *          시간초과가 날 수 있다.
 *      따라서 int 배열에 그 전 방문했던 지점을 저장하고 stack을 사용해 역순으로 나열하여 출력하였다.
 *
**/
public class dfs_bfs09 {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int min = Integer.MAX_VALUE;

    static int[] prev = new int[100001];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            visited[node.x] = true;

            if (node.x == K) {
                min = Math.min(min, node.time);
                int X = K;
                while (X != N) {
                    stack.push(X);
                    X = prev[X];
                }
                stack.push(N);
                break;
            }
            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                q.offer(new Node(node.x - 1, node.time + 1));
                prev[node.x - 1] = node.x;
                visited[node.x-1] = true;
            }

            if (node.x + 1 <= 100000 && !visited[node.x + 1]) {
                q.offer(new Node(node.x + 1, node.time + 1));
                prev[node.x + 1] = node.x;
                visited[node.x+1] = true;
            }

            if (node.x * 2 <= 100000 && !visited[node.x * 2]) {
                q.offer(new Node(node.x * 2, node.time + 1));
                prev[node.x * 2] = node.x;
                visited[node.x*2] = true;
            }


        }


    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}
