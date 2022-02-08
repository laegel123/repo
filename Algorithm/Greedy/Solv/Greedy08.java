import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * CodeUp : 최소대금
 *
 *
 */
public class Greedy08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int temp = b - a;
        int count = 0;

        while (temp > 0) {
            if (temp >= 10) {
                count += temp / 10;
                temp = temp % 10;
            } else {
                if (temp >= 5) {
                    count += 1;
                    temp = temp - 5;
                } else {
                    
                }

            }
        }

    }
}
