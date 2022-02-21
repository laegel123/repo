package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOj : 전투
 * https://www.acmicpc.net/problem/1303
 * 주의사항 : 가로 세로 값 주의. 이것때문에 30분 넘게 고민했다..
 *
**/
public class dfs_bfs02 {

    // 방향 변수 저장
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static String[][] army;
    static boolean[][] visited;

    static int width = 0;
    static int length = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        army = new String[width][length];
        visited = new boolean[width][length];

        for (int i = 0; i < width; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < length; j++) {
                army[i][j] = str[j];
            }
        }

        int wNum = 0;
        int bNum = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (!visited[i][j]) {
                    int power = 1;
                    power = dfs(army[i][j], i, j, power);

                    if (army[i][j].equals("W")) {
                        wNum += power * power;
                    } else {
                        bNum += power * power;
                    }
                }
            }
        }

        System.out.println(wNum + " " + bNum);

    }

    /**
     * @param color:색 구별 param, i: x방향, y: y방향, power: 근접 병사 합한 갯수
     * @return power: 근접 병사 합한 갯수
     * @desc
     **/
    public static int dfs(String color, int i, int j, int power) {
        visited[i][j] = true;

        for (int x = 0; x < dx.length; x++) {
            int nowX = i + dx[x];
            int nowY = j + dy[x];

            if (nowX < 0 || nowX >= width || nowY < 0 || nowY >= length) {
                continue;
            }
            if (!army[nowX][nowY].equals(color) || visited[nowX][nowY]) {
                continue;
            }

            power++;
            power = dfs(color, nowX, nowY, power);
        }




        return power;

    }


}
