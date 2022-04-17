package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 바이러스
 * https://www.acmicpc.net/problem/2606
 * bfs로 해결
 *
**/
public class dfs_bfs05_2 {

    static int[][] map;
    static boolean[] visited;

    static int tCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cptNum = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        map = new int[cptNum + 1][cptNum + 1];
        visited = new boolean[cptNum + 1];

        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            map[i][j] = 1;
            map[j][i] = 1;

        }

        bfs(1);
        System.out.println(tCnt);

    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y = 1; y < visited.length; y++) {
                if (x != y && map[x][y] == 1 && !visited[y]) {
                    tCnt++;
                    q.add(y);
                    visited[y] = true;
                }
            }

        }
    }
}
