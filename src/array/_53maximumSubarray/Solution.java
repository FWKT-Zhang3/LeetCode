package array._53maximumSubarray;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/2 15:49
 * @Description: Given an integer array nums, find the contiguous subarray
 *      (containing at least one number) which has the largest sum and return
 *      its sum.
 *
 *      Follow up: If you have figured out the O(n) solution, try coding
 *      another solution using the divide and conquer approach, which is more
 *      subtle.
 *
 * Note: 没想到什么好的想法，脑子里塞满了遍历
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        // dp algorithm
//        if (nums.length == 1) return nums[0];
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int max = nums[0];
//
//        for (int i = 1; i < n; i++) {
//            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;

        // Another version, require less space and time
        if (nums.length == 1) return nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
