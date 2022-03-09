import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * BOJ : 전투
 * https://www.acmicpc.net/problem/1303
 * 문제 
 *
 **/
public class dfs_bfs02_2 {

    static int length = 0;
    static int width = 0;
    static int[][] army;
    static boolean[][] visited;
    static int power;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        army = new int[width][length];
        visited = new boolean[width][length];

        for (int i = 0; i < width; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < length; j++) {
                army[i][j] = str[j].equals("W") ? 0 : 1;
            }
        }

        int wNum = 0;
        int bNum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                power = 1;
                if (!visited[i][j]) {
                    dfs(army[i][j], i, j);
                    if (army[i][j] == 0) {
                        wNum += power * power;
                    } else {
                        bNum += power * power;
                    }
                }
            }
        }

        System.out.println(wNum + " " + bNum);


    }

    public static void dfs(int armyType, int i, int j) {
        visited[i][j] = true;

        for (int x = 0; x < dx.length; x++) {
            int nowX = i + dx[x];
            int nowY = j + dy[x];

            if (nowX >= width || nowX < 0 || nowY >= length || nowY < 0) {
                continue;
            }

            if (army[nowX][nowY] != armyType || visited[nowX][nowY]) {
                continue;
            }

            power++;
            dfs(armyType, nowX, nowY);
        }
    }


}
