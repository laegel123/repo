
/**
 *
 * leetCode : Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
**/

public class etc01 {
    public static void main(String[] args) {

        int problem = 1000021;

        System.out.println(isPalindrome(problem));

    }

    public static boolean isPalindrome(int x) {
        int length = (int) (Math.log10(x) + 1);

        if (x == 0) {
            return true;
        }

        if (x < 0) {
            return false;
        }

        String[] strNum = String.valueOf(x).split("");

        int first = 0;
        int end = strNum.length - 1;

        for (int i = 0; i < strNum.length / 2; i++) {
            if (!strNum[first].equals(strNum[end])) {
                return false;
            }
            first++;
            end--;
        }

        return true;
    }
}
