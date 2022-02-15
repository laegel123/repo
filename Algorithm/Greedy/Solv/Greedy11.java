import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 코드업 : 펜션
 * https://codeup.kr/problem.php?id=4040
 *
 *
 */

public class Main {

    static int n;
    static int m;
    static int endDay;
    static int startDay;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] strArr = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = strArr[j];
            }
        }

        st = new StringTokenizer(br.readLine());
        startDay = Integer.parseInt(st.nextToken());
        endDay = Integer.parseInt(st.nextToken());

        int cnt = -1;

        for (int i = startDay - 1; i < endDay - 1;) {
            cnt++;
            if (greedy(i) == 0) {
                cnt = -1;
                break;
            }
            i += greedy(i);
        }

        System.out.println(cnt);





    }


    public static int greedy(int index) {
        int maxDay = 0;

        for (int i = 0; i < m; i++) {
            int day = 0;
            for (int j = index; j < endDay-1; j++) {
                if (arr[j][i].equals("O")) {
                    day ++;
                } else {
                    break;
                }
                if (maxDay < day) {
                    maxDay = day;
                }
            }
        }

        return maxDay;
    }

}
