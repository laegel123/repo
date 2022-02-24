package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_bfs04 {

    static int width = 0;
    static int length = 0;
    static int trashNum = 0;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        trashNum = Integer.parseInt(st.nextToken());

        map = new int[width][length];
        visited = new boolean[width][length];

        for (int i = 0; i < trashNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            map[x][y] = 1;
        }

        int size = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (!visited[i][j]) {

                }
            }
        }
        dfs(0, 0);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        if (map[i][j] == 1) {
            size++;
        }

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
            dfs(nowX, nowY);


        }
    }
}
