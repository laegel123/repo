import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * CodeUp : 거스름돈
 * https://codeup.kr/problem.php?id=3301
 *
 */
public class Greedy09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int count = 0;

        int i = 0;
        while (n > 0) {
            if (n / coin[i] > 0) {
                count += n / coin[i];
                n = n % coin[i];
            }
            i++;
            
        }

        System.out.println(count);



    }
}
