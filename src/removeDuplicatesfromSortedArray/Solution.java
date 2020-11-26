package removeDuplicatesfromSortedArray;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/26 14:55
 * @Description: Given a sorted array nums, remove the duplicates in-place such
 * that each element appears only once and returns the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        // 自己的写法，先找到不重复的点，再挪数字
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length, pre = nums[0], count = 0;
        if (len == 1) return 1;
        for (int i = 1; i < len; i++) {
            while (i < len) {
                if (nums[i] == pre) {
                    i++;
                    count++;
                }
                else break;
            }
            if (i < len) {
                nums[i-count] = nums[i];
                pre = nums[i-count];
            }
        }
        return len - count;

        // 别人的写法，发现重复就立即挪数字
//        if (nums == null || nums.length == 0) return 0;
//        int len = nums.length, count = 0;
//        if (len == 1) return 1;
//        for (int i = 1; i < len; i++) {
//            if (nums[i] == nums[i - 1]) {
//                count++;
//            }
//            nums[i - count] = nums[i];
//        }
//        return len - count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
