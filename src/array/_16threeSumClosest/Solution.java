package array._16threeSumClosest;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/25 17:07
 * @Description: Given an array nums of n integers and an integer target, find
 *      three integers in nums such that the sum is closest to target. Return
 *      the sum of the three integers. You may assume that each input would have
 *      exactly one solution.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // 可读性很强，也很简洁
        int n = nums.length, minValue = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = n - 1, sum;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right] - target;
                if (sum == 0) {
                    return target;
                }
                if (Math.abs(sum) < Math.abs(minValue)) minValue = sum;
                if (sum > 0) right--;
                else left++;
            }
        }

        return minValue + target;

//        int n = nums.length, minValue = Integer.MAX_VALUE, ans = 0;
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < n - 2; i++) {
//            if (i > 0 && nums[i] == nums[i-1]) continue;
//
//            int left = i + 1, right = n - 1, sum, r;
//            while (left < right) {
//                sum = nums[i] + nums[left] + nums[right];
//                r = sum - target;
//                if (r == 0) {
//                    return sum;
//                } else if (r < 0) {
//                    if (Math.abs(r) < minValue) {
//                        minValue = Math.abs(r);
//                        ans = sum;
//                    }
//                    left++;
//                } else {
//                    if (Math.abs(r) < minValue) {
//                        minValue = Math.abs(r);
//                        ans = sum;
//                    }
//                    right--;
//                }
//            }
//        }
//        return ans;
    }
}
