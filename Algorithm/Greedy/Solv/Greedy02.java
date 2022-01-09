import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ - 유기농 배추
 * https://www.acmicpc.net/problem/1012
 *
 *
 */

public class Greedy02 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] pos = new int[m][n];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pos[a][b]++;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                if () {
                }
            }
        }


    }
}
