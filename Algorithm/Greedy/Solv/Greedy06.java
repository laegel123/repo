import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * 이코테 : 큰 수의 법칙
 *
 *
 */
public class Greedy06 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());

        // counting sort
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int fstNum = arr[0];
        int scdNum = 0;
        for (int i = 0; i < n; i++) {
            if (fstNum != arr[i]) {
                scdNum = arr[i];
                break;
            }
        }
        int total = 0;
        int count = 0;
        while (m-- > 0) {
            count ++;

            if (count != 3) {
                total += fstNum;
            } else {
                total += scdNum;
                count = 0;
            }
        }

        System.out.println(total);

    }
}
