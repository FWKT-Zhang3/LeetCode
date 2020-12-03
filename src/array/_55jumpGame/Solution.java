package array._55jumpGame;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/3 16:21
 * @Description: Given an array of non-negative integers, you are initially
 *      positioned at the first index of the array.
 *
 *      Each element in the array represents your maximum jump length at that
 *      position.
 *
 *      Determine if you are able to reach the last index.
 */
public class Solution {
    public boolean canJump(int[] nums) {
//        if (nums.length <= 1) return true;
//        int curMax = nums[0];
//
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (i > curMax) return false;
//            if (curMax >= nums.length - 1) return true;
//            curMax = Math.max( curMax, (nums[i] + i));
//        }
//
//        return false;
        // 另一种思路，这样更快
        if (nums.length <= 1) return true;
        int t = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((nums[i] + i) >= t) t = i;
        }
        return t == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
    }
}
