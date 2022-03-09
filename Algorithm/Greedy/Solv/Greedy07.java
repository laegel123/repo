import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * CodeUp : 최소대금
 *
 *
 */
public class Greedy07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] pasta = new int[3];
        int[] juice = new int[2];

        // 초기화
        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                pasta[i] = Integer.parseInt(br.readLine());
            } else {
                juice[i - 3] = Integer.parseInt(br.readLine());
            }
        }

        // 정렬
        Arrays.sort(pasta);
        Arrays.sort(juice);

        double price = Math.round((pasta[0] + juice[0]) * 11) / 10.0;


        System.out.println(price);




    }


}
