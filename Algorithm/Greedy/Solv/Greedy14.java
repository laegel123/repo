import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * BOJ : 스테이크버드
 * https://www.acmicpc.net/problem/16435
 *
 **/
public class Greedy14 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fruitkinds = Integer.parseInt(st.nextToken());
        int birdLength = Integer.parseInt(st.nextToken());
        
        int[] height = new int[fruitkinds];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < fruitkinds; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(height);

        for (int i = 0; i < height.length; i++) {
            if (birdLength >= height[i]) {
                birdLength++;
            } else {
                break;
            }
        }

        System.out.println(birdLength);
        



    }
}
