package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOj : 전투
 * https://www.acmicpc.net/problem/1303
 *
**/
public class dfs_bfs02 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        String[][] army = new String[width][length];
        boolean[][] visited = new boolean[width][length];

        for (int i = 0; i < width; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < length; j++) {
                army[i][j] = str[j];
            }
        }


    }

    /**
    * @param color:적군,아군 구분 색 / army:전쟁군인 배열 / visited: 방문여부
    * @return power:
    * @desc
    **/
    public static void dfs(String color, String[][] army, boolean[][] visited) {
        // 시작은 (0,0) 부터
        visited[0][0] = true;


    }


}
