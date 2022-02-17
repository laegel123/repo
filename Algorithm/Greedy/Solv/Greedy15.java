import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * BOJ : 시험 감독
 * https://www.acmicpc.net/problem/13458
 *
 **/
public class Greedy15 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] people = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long total = 0;

        for (int i = 0; i < n; i++) {
            total++;
            people[i] -= b;

            if (people[i] > 0) {
                total += people[i] / c;

                if (people[i] % c != 0) {
                    total ++;
                }
            }
        }

        System.out.println(total);


    }
}
