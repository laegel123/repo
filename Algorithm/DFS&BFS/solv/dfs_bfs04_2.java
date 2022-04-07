import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs_bfs04_2 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited;
    static int[][] food;

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        food = new int[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            food[a][b] = 1;
        }

        int maxSize = 0;
        int currentSize = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (food[i][j] == 1 && !visited[i][j]) {
                    currentSize = bfs(i, j);

                    if (currentSize > maxSize) {
                        maxSize = currentSize;
                    }
                }

            }
        }

        System.out.println(maxSize);

    }

    static int bfs(int i, int j) {
        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] nowXY = q.poll();

            for (int x = 0; x < 4; x++) {
                int newX = nowXY[0] + dx[x];
                int newY = nowXY[1] + dy[x];

                if (newX < 1 || newX > N || newY < 1 || newY > M) {
                    continue;
                }

                if (food[newX][newY] == 0 || visited[newX][newY]) {
                    continue;
                }

                q.add(new int[]{newX, newY});
                visited[newX][newY] = true;
                size++;
            }

        }

        return size;
    }
}
