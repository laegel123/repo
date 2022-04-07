import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_bfs03_2 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N;
    static int M;

    static boolean[][] visited;
    static int[][] miro;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        miro = new int[N + 1][M + 1];

        for (int i = 1; i < N+1; i++) {
            String[] str = br.readLine().split("");

            for (int j = 1; j < M + 1; j++) {
                miro[i][j] = Integer.parseInt(str[j - 1]);
            }
        }

        bfs(1, 1);

        System.out.println(miro[N][M]);

    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] nowXY = q.poll();
            //visited[nowXY[0]][nowXY[1]] = true;

            for (int i = 0; i < 4; i++) {
                int newX = nowXY[0] + dx[i];
                int newY = nowXY[1] + dy[i];

                if (newX < 1 || newX > N || newY < 1 || newY > M) {
                    continue;
                }

                if (miro[newX][newY] == 0 || visited[newX][newY]) {
                    continue;
                }

                miro[newX][newY] = miro[nowXY[0]][nowXY[1]] + 1;
                visited[newX][newY] = true;
                q.add(new int[]{newX, newY});

                if (newX == N && newY == M) {
                    return;
                }



            }

        }


    }
}
