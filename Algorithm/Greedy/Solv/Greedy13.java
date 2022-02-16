import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 주유소
 * https://www.acmicpc.net/problem/13305
 *
**/
public class Greedy13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] width = new int[n - 1];
        int[] cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            width[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        



    }
}
