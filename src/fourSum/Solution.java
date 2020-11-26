package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/26 13:21
 * @Description: Given an array nums of n integers and an integer target, are
 *      there elements a, b, c, and d in nums such that a + b + c + d = target?
 *      Find all unique quadruplets in the array which gives the sum of target.
 *
 * Notice that the solution set must not contain duplicate quadruplets.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 自己的写法，只是3Sum的简单拓展，O(n^3)
//        List<List<Integer>> ans = new ArrayList<>();
//        int n = nums.length;
//        if (n < 4) return ans;
//
//        Arrays.sort(nums);
//
//        for (int m = 0; m < n - 3; m++) {
//            if (m > 0 && nums[m] == nums[m - 1]) continue;
//            for (int i = m + 1; i < n - 2; i++) {
//                if (i > m + 1 && nums[i] == nums[i - 1]) continue;
//                int left = i + 1, right = n - 1, sum;
//                while (left < right) {
//                    sum = nums[m] + nums[i] + nums[left] + nums[right] - target;
//                    if (sum == 0) {
//                        ans.add(Arrays.asList(nums[m], nums[i], nums[left], nums[right]));
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                        left++;
//                        right--;
//                    } else if (sum < 0) left++;
//                    else right--;
//                }
//            }
//
//        }
//        return ans;

        /*
         * 其中一个大佬的写法，将4sum换成3sum，2sum，比较亮眼的地方是每次算sum之前都有一个验证
         * 的过程，可以减少一些不必要的计算
         */
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        int len = nums.length;
        if (len < 4) return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /**
     * 大佬的算法的辅助函数1
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /**
     * 大佬的算法的辅助函数2
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
    }

    /**
     * Generalized KSum Algorithm
     *
     * @param a the provided array to find result
     * @param target the target number
     * @param k the number of elements to sum
     * @return all possible results
     */
    List<List<Integer>> kSum_Trim(int[] a, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSum_Trim(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * The auxiliary function to solve the kSum problem.
     * The main body of the algorithm
     *
     * @param a the provided array to find result
     * @param target the target number
     * @param k the number of elements to sum
     * @param start the start index
     * @param result the list of possible results
     * @param path the selected members
     */
    void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if      (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++; right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        }
        else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                if (a[i] + max * (k - 1) < target) continue;
                if (a[i] * k > target) break;
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                path.add(a[i]);
                kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }
    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.kSum_Trim(new int[]{-3,-1,0,2,4,5}, 2,4));
    }
}
