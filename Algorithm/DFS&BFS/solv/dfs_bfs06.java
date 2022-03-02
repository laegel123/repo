package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 숨바꼭질
 * https://www.acmicpc.net/problem/12851
 *
 **/
public class dfs_bfs06 {
    static int start;
    static int target;
    static int min = Integer.MAX_VALUE;
    static int route = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        if (start >= target) {
            System.out.println(start - target);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(min);
        System.out.println(route);

    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];

        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (min < visited[now]) {
                return;
            }

            int[] move = new int[]{now - 1, now + 1, now * 2};

            for (int i = 0; i < 3; i++) {
                int next = move[i];

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == target) {
                    min = visited[now];
                    route++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    q.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }


}
