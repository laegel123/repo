import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * BOJ : 전투
 * https://www.acmicpc.net/problem/1303
 * bfs로 구현
 **/
public class dfs_bfs02_3 {

    static int width = 0;
    static int length = 0;

    static int[][] army;
    static boolean[][] visited;

    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int power;


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

        int wPower = 0;
        int bPower = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (!visited[i][j]) {
                    power = 1;
                    bfs(army[i][j], i, j);

                    if (army[i][j] == 0) {
                        wPower += power * power;
                    } else {
                        bPower += power * power;
                    }

                }
            }
        }

        System.out.println(wPower + " " + bPower);

    }

    public static void bfs(int armyType, int i, int j) {
        visited[i][j] = true;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()){
            int[] xY = q.poll();

            for (int x = 0; x < dx.length; x++) {
                int nowX = xY[0] + dx[x];
                int nowY = xY[1] + dy[x];

                if (nowX >= width || nowX < 0 || nowY >= length || nowY < 0) {
                    continue;
                }

                if (army[nowX][nowY] != armyType || visited[nowX][nowY]) {
                    continue;
                }

                power ++;
                visited[nowX][nowY] = true;
                q.offer(new int[]{nowX, nowY});


            }

        }

    }



}
