package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOJ - 음식물 피하기 (1743번)
 * https://www.acmicpc.net/problem/1743
 *
 **/
public class dfs_bfs04 {
    static int width = 0;
    static int length = 0;
    static int trashNum = 0;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        trashNum = Integer.parseInt(st.nextToken());

        map = new int[width][length];
        visited = new boolean[width][length];

        for (int i = 0; i < trashNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            map[x][y] = 1;
        }

        int maxSize = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                size = 0;
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (map[i][j] == 1) {
                        size++;
                    }
                    dfs(i, j);
                    if (size > maxSize){
                        maxSize = size;
                    }
                }
            }
        }

        System.out.println(maxSize);
    }

    public static void dfs(int i, int j) {

        for (int x = 0; x < dx.length; x++) {
            int nowX = i + dx[x];
            int nowY = j + dy[x];

            if (nowX >= width || nowX < 0 || nowY >= length || nowY < 0) {
                continue;
            }

            if (map[nowX][nowY] == 0 || visited[nowX][nowY]) {
                continue;
            }

            visited[nowX][nowY] = true;
            if (map[nowX][nowY] == 1) {
                size++;
            }
            dfs(nowX, nowY);


        }
    }
}
