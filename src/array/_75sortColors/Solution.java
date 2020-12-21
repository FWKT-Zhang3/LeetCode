package array._75sortColors;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/21 15:53
 * @Description: Given an array nums with n objects colored red, white, or blue,
 *      sort them in-place so that objects of the same color are adjacent, with
 *      the colors in the order red, white, and blue.
 *
 *      Here, we will use the integers 0, 1, and 2 to represent the color red,
 *      white, and blue respectively.
 *
 * Follow up:
 *
 *      Could you solve this problem without using the library's sort function?
 *      Could you come up with a one-pass algorithm using only O(1) constant
 *      space?
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int n = 0, m = nums.length - 1, i = 0;
        while (i <= m) {
            if (nums[i] == 0) {
                if (nums[n] != 0) {
                    swap(i, n, nums);
                }
                i++;
                n++;
            } else if (nums[i] == 2) {
                if (nums[m] != 2) {
                    swap(i, m, nums);
                }
                m--;
            } else i++;
        }

        // counting sort,
        // 在这种情况下(知道准确的参数种类的数量)，计数排序也是很好的选择
//        if (nums == null || nums.length < 2) return;
//        int[] count = new int[3];
//        for (int i : nums) {
//            count[i]++;
//        }
//        count[1] = count[0] + count[1];
//        for (int i = 0; i < nums.length; i++) {
//            if (i < count[0]) nums[i] = 0;
//            else if (i < count[1]) nums[i] = 1;
//            else nums[i] = 2;
//        }
    }

    public void swap(int n, int m, int[] nums) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    public static void main(String[] args) {
        int[] t = new int[]{2,0,2,1,1,0};
        Solution s = new Solution();
        s.sortColors(t);
        System.out.println(Arrays.toString(t));
    }
}
