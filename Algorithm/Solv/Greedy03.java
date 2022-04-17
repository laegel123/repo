import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ - 주식
 * https://www.acmicpc.net/problem/11501
 *
 * for문을 반대로 돌아 max 값 갱신하는 식으로 해결
 *
 */
public class Greedy03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] stocks = new long[n];

            // 배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            long total = 0;
            long max = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (stocks[i] > max) {
                    max = stocks[i];
                } else {
                    total += max - stocks[i];
                }
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);


    }
}
