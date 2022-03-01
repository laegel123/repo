package Solv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * BOJ : A -> B
 * https://www.acmicpc.net/problem/16953
 *
**/
public class bfs_dfs06 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;
        // B -> A 로 가는 방법으로 해결
        while (B != A) {
            String str = String.valueOf(B);
            if (B % 2 != 0 && str.charAt(str.length() - 1) != '1') {
                count = -1;
                break;
            }

            if (B % 2 == 0) {
                B = B / 2;
            } else if (str.charAt(str.length() - 1) == '1') {
                str = str.substring(0, str.length() - 1);
                if (str.equals("")) {
                    count = -1;
                    break;
                }
                B = Integer.parseInt(str);
            }

            count++;


        }

        System.out.println(count);

    }
}
