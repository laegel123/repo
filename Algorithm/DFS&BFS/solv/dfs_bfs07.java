package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 숨바꼭질3
 * https://www.acmicpc.net/problem/13549
 *
**/
public class dfs_bfs07 {

    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        bfs();
        System.out.println(min);


    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            visited[node.x] = true;

            if (node.x == K) {
                min = Math.min(min, node.time);
            }

            if (node.x * 2 <= 100000 && !visited[node.x * 2]) {
                q.offer(new Node(node.x * 2, node.time));
            }
            if (node.x + 1 <= 100000 && !visited[node.x + 1]) {
                q.offer(new Node(node.x + 1, node.time + 1));
            }
            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                q.offer(new Node(node.x - 1, node.time + 1));
            }

        }

    }


    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }


}
