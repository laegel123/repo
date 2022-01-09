import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * BOJ - 동전0
 * https://www.acmicpc.net/problem/11047
 *
 *
 */

public class Greedy01 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;

        for (int i = 0; i < n; i++) {
            if (k / coin[i] > 0) {
                total += k/coin[i];
                k %= coin[i];
            }
        }

        System.out.println(total);

    }
}
