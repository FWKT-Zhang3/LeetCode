package removeElement;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/27 14:01
 * @Description: Given an array nums and a value val, remove all instances of
 *      that value in-place and return the new length.
 *
 *      Do not allocate extra space for another array, you must do this by
 *      modifying the input array in-place with O(1) extra memory.
 *
 *      The order of elements can be changed. It doesn't matter what you leave
 *      beyond the new length.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1 && nums[0] == val) return 0;
        int count = 0;

        for (int i = 0; i < len; i++) {
            while (i < len && nums[i] == val) {
                count++;
                i++;
            }
            if (i < len) nums[i - count] = nums[i];
        }

        return len - count;
    }
}
