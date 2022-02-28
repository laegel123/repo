package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 바이러스
 * https://www.acmicpc.net/problem/2606
 *
**/
public class dfs_bfs05 {

    static int cptNum = 0;
    static int[][] map;
    static boolean[] visited;

    static int tCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cptNum = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        map = new int[cptNum+1][cptNum+1];
        visited = new boolean[cptNum+1];

        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(1);

        System.out.println(tCnt);


    }

    public static void dfs(int i) {
        visited[i] = true;

        for (int j = 1; j < cptNum + 1; j++) {
            if (map[i][j] == 1 && !visited[j]) {
                tCnt++;
                dfs(j);
            }
        }
    }


}
