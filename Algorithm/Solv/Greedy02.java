import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ - ATM
 * https://www.acmicpc.net/problem/11399
 *
 *
 */

public class Greedy02 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] time = new int[1001];
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            time[a]++;
        }

        int total = 0;

        for (int i = 0; i < time.length; i++) {
            while (time[i] > 0) {
                total += time[i] + total;

            }
        }

        System.out.println(total);



    }
}
