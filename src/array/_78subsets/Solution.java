package array._78subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/21 17:06
 * @Description: Given an integer array nums, return all possible subsets
 * (the power set).
 * <p>
 * The solution set must not contain duplicate subsets.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //自己的写法，我就是一纯傻逼
//        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(new ArrayList<>());
//        if (nums == null) return ans;
//        if (nums.length == 1) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            temp.add(nums[0]);
//            ans.add(temp);
//            return ans;
//        }
//        Arrays.sort(nums);
//
//        List<Integer> path = new ArrayList<>();
//        for (int k = 1; k <= nums.length; k++){
//            subsetsRecursion(nums, ans, path, 0, k);
//        }
//        return ans;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> temp,
                          int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 自己写法的辅助函数
     *
     * @param nums  provided array
     * @param ans   the output List
     * @param path  the path of the number
     * @param start the index of the start position
     * @param k     the number of numbers needed
     */
    public void subsetsRecursion(int[] nums, List<List<Integer>> ans,
                                 List<Integer> path, int start, int k) {
        if (start >= nums.length) return;
        if (k == 1) {
            while (start > 0 && nums[start] == nums[start - 1]) start++;
            path.add(nums[start]);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            subsetsRecursion(nums, ans, path, ++start, k);
        } else {
            for (int i = start; i < nums.length; i++) {
                while (i > start && nums[i] == nums[i - 1]) i++;
                path.add(nums[i]);
                subsetsRecursion(nums, ans, path, i + 1, k - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{0};
        Solution s = new Solution();
        List<List<Integer>> ans = s.subsets(n);
        for (List<Integer> m : ans) {
            System.out.println(m);
        }
    }
}
