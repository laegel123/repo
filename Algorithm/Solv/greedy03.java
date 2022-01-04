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
public class greedy03 {

    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[] arr;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];

            // 배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int total = 0;
            int max = arr[n-1];
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < max) {
                    total += max-arr[i];
                } else {
                    max = arr[i];
                }
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);


    }
}
