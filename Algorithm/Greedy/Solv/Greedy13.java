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
public class Greedy14 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] width = new long[n - 1];
        long[] cost = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            width[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        // 리터당 기름값 내림차순일 경우 저장
        for (int i = 0; i < n; i++) {
            long newCost = Long.parseLong(st.nextToken());
            if (i == 0) {
                cost[i] = newCost;
            } else {
                if (newCost > cost[i-1]) {
                    cost[i] = cost[i-1];
                } else {
                    cost[i] = newCost;
                }
            }
        }

        long minCost = 0;

        for (int i = 0; i < n-1; i++) {
            minCost += cost[i] * width[i];
        }

        System.out.println(minCost);





    }
}
