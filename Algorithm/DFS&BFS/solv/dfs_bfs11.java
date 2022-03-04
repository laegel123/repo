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
 * 틀림 수정필요
 *
**/
public class dfs_bfs11 {
    static int[][] map;
    static int[][] distance;
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
        distance = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(maxDistance);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0] = true;
        distance[0][0] = 1;

        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            Node node = q.poll();

            int count = 0;
            for (int i = 0; i < dx.length; i++) {
                int nowX = node.i + dx[i];
                int nowY = node.j + dy[i];

                if (nowX < 0 || nowX >= N || nowY < 0 || nowY >= M) {
                    continue;
                }

                if (map[node.i][node.j] == 1) {
                    distance[node.i][node.j] = 1;
                    continue;
                }

                if (map[nowX][nowY] == 1 && !visited[node.i][node.j]) {
                    count = distance[node.passI][node.passJ];
                    visited[node.i][node.j] = true;
                }
                if (map[nowX][nowY] == 0 && !visited[node.i][node.j]) {
                    count = distance[node.passI][node.passJ] + 1;

                }

                distance[node.i][node.j] = count;
                visited[node.i][node.j] = true;

                if (!visited[nowX][nowY]) {
                    q.offer(new Node(nowX, nowY, node.i, node.j));
                }

                if (maxDistance < count) {
                    maxDistance = count;
                }



            }


        }

    }

    public static class Node {
        int i;
        int j;
        int passI;
        int passJ;

        public Node(int i, int j, int passI, int passJ) {
            this.i = i;
            this.j = j;
            this.passI = passI;
            this.passJ = passJ;
        }
    }

}
