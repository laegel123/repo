import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * CodeUp : 최고의 피자
 * https://codeup.kr/problem.php?id=3321
 *
**/
public class Greedy10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int toppingKinds = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int doughPrice = Integer.parseInt(st.nextToken());
        int toppingPrice = Integer.parseInt(st.nextToken());

        int doughCalorie = Integer.parseInt(br.readLine());

        int bestPizzaCalorie = doughCalorie / doughPrice;

        Integer[] toppingCalArr = new Integer[toppingKinds];
        for (int i = 0; i < toppingKinds; i++) {
            toppingCalArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(toppingCalArr, Collections.reverseOrder());

        int totalPrice = doughPrice;
        int totalCal = doughCalorie;
        int i = 0;
        while (toppingKinds-- > 0) {
            totalPrice += toppingPrice;
            totalCal += toppingCalArr[i];

            int newPizzaCal = totalCal / totalPrice;

            if (newPizzaCal > bestPizzaCalorie) {
                bestPizzaCalorie = newPizzaCal;
            }
            i++;
        }

        System.out.println(bestPizzaCalorie);
    }
}
