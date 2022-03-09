import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * CodeUp : 리모컨
 *
 *
 */
public class Greedy08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int temp = Math.abs(b - a);
        int count = 0;

        while (temp > 0) {
            if (temp >= 10) {
                count += temp / 10;
                temp = temp % 10;
            } else {
                if (temp == 9 || temp == 6 || temp == 4 || temp == 2) {
                    count += 2;
                } else if (temp == 8 || temp == 7 || temp == 3) {
                    count += 3;
                } else if (temp == 5 || temp == 1) {
                    count += 1;
                }

                temp = 0;
                
            }
        }

        System.out.println(count);

    }
}
