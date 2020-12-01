package array._15threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/25 14:45
 * @Description: Given an array nums of n integers, are there elements a, b, c
 *      in nums such that a + b + c = 0? Find all unique triplets in the array
 *      which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = n - 1, sum;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间： " + (endTime - start) + "ms");
    }
}
