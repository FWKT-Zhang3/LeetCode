package array._66plusOne;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/8 16:49
 * @Description: Given a non-empty array of decimal digits representing a
 *      non-negative integer, increment one to the integer.
 *
 *      The digits are stored such that the most significant digit is at the
 *      head of the list, and each element in the array contains a single digit.
 *
 *      You may assume the integer does not contain any leading zero, except
 *      the number 0 itself.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        while (digits[len] == 9) {
            if (len == 0) {
                int[] ans = new int[digits.length + 1];
                ans[0] = 1;
                return ans;
            }
            digits[len] = 0;
            len--;
        }
        digits[len]++;
        return digits;

        // 占用空间略大
//        int n = digits.length;
//        int carry = 1;
//
//        for (int i = n - 1; i >= 0; i--) {
//            int temp = digits[i] + carry;
//            if (temp < 10) {
//                digits[i] = temp % 10;
//                carry = 0;
//                break;
//            } else {
//                digits[i] = 0;
//            }
//        }
//
//        if (carry == 1) {
//            int[] ans = new int[n + 1];
//            ans[0] = 1;
//            return ans;
//        } else return digits;

        // 这个写法太麻烦了
//        int len = digits.length;
//        if (len < 10) {
//            long i = 0;
//            long carry = 1;
//            for (int digit : digits) {
//                i = i * 10 + digit;
//                if (digit != 9) carry = 0;
//            }
//            i++;
//            int[] ans = new int[digits.length + (int) carry];
//            for (int t = ans.length - 1; t >= 0; t--) {
//                ans[t] = (int) (i % 10);
//                i = i / 10;
//            }
//            return ans;
//        } else {
//            ArrayList<Integer> ans = new ArrayList<>();
//            int carry = 1;
//            for (int t = len - 1; t >= 0; t--) {
//                if (carry == 0) {
//                    ans.add(digits[t]);
//                } else {
//                    ans.add((digits[t] + 1) % 10);
//                }
//                if (digits[t] != 9) carry = 0;
//                if (t == 0 && carry == 1) ans.add(1);
//            }
//            int[] a = new int[ans.size()];
//            for (int t = 0; t < a.length; t++) {
//                a[t] = ans.get(a.length - 1 - t);
//            }
//            return a;
//        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
    }
}
