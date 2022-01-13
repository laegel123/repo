import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrSort = new int[10001];

        // counting Sort
        for (int i = 0; i < N; i++) {
            arrSort[Integer.parseInt(br.readLine())]++;
        }

        int maxWeight = 0;
        int count = N;

        for (int i = 0; i < arrSort.length; i++) {
            while (arrSort[i]-- > 0) {
                if (maxWeight < i * count) {
                    maxWeight = i * count;
                }
                count--;
            }
        }

        br.close();
        System.out.println(maxWeight);




    }

}
