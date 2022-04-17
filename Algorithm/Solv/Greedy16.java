import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Greedy16 {
    /**
     * leetcode - Last Stone Weight
     * https://leetcode.com/problems/last-stone-weight/
     **/

    public static void main(String[] args) throws IOException {

        int[] test = {2};

        System.out.println(lastStoneWeight(test));
    }

    public static int lastStoneWeight(int[] stones) {
        // 우선순위 큐를 사용하여 바로 역순 정렬
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i: stones) {
            q.add(i);
        }

        while (q.size() > 1) {
            int x = q.poll();
            int y = q.poll();

            if (x > y) {
                q.add(x - y);
            }
        }

        return q.isEmpty() ? 0 :q.poll();
    }
}
