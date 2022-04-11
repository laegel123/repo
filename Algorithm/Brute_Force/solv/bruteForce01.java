import java.util.Arrays;

/**
 *
 * leetCode : Two Sum
 * https://leetcode.com/problems/two-sum/
 *
**/
public class bruteForce01 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] answer = twoSum(nums, 6);

        System.out.println(Arrays.toString(answer));

    }

    public static int[] twoSum(int[] nums, int target) {
        int count = nums.length;
        int[] answer = new int[2];

        while (count-- > 0) {
            int num = nums.length - (count + 1);
            for (int i = nums.length - count; i < nums.length; i++) {
                if (target-nums[num] == nums[i]) {
                    answer[0] = num;
                    answer[1] = i;
                    break;
                }
            }
        }


        return answer;
    }
}
