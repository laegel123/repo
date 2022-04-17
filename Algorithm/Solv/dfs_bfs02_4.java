import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOj : 전투
 * https://www.acmicpc.net/problem/1303
 * 다시 풀어봄.
 *
 **/

public class dfs_bfs02_4 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited;
    static int[][] army;

    static int count = 0;

    static int a;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        visited = new boolean[a][b];
        army = new int[a][b];

        for (int i = 0; i < a; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < b; j++) {
                army[i][j] = str[j].equals("W") ? 1 : 0;
            }
        }

        int white_count = 0;
        int blue_count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                count = 0;
                // white팀일 경우
                if (army[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, 1);
                    white_count += count*count;
                }
                // blue 팀일 경우
                if (army[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, 0);
                    blue_count += count*count;
                }
            }
        }

        sb.append(white_count).append(" ").append(blue_count);
        System.out.println(sb);



    }

    static void dfs(int i, int j, int type) {
        visited[i][j] = true;
        count ++;

        for (int x = 0; x < 4; x++) {
            int newI = i + dx[x];
            int newJ = j + dy[x];

            if (newI < 0 || newI >= a || newJ < 0 || newJ >= b) {
                continue;
            }

            if (army[newI][newJ] == type && !visited[newI][newJ]) {
                dfs(newI, newJ, type);
            }
        }
    }
}
