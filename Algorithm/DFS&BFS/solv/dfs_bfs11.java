package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 아기상어2
 * https://www.acmicpc.net/problem/17086
 * 메모리 초
 *
**/
public class dfs_bfs11 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int maxDistance = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxDistance);
    }

    public static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        visited[i][j] = true;
        int cnt = 0;

        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            for (int s = 0; s < q.size(); s++) {
                Node node = q.poll();

                if (map[node.i][node.j] == 1) {
                    maxDistance = Math.max(maxDistance, cnt);

                    return;
                }

                for (int x = 0; x < dx.length; x++) {
                    int nowX = node.i + dx[x];
                    int nowY = node.j + dy[x];

                    if (!(nowX >= 0 && nowX < N && nowY >= 0 && nowY < M) || visited[nowX][nowY]) {
                        continue;
                    }

                    visited[nowX][nowY] = true;
                    q.offer(new Node(nowX, nowY));
                }

                cnt++;
            }
        }

    }

    public static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


}
