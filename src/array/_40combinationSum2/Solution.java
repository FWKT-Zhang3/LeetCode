package array._40combinationSum2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/30 14:56
 * @Description: Given a collection of candidate numbers (candidates) and a
 *      target number (target), find all unique combinations in candidates where
 *      the candidate numbers sum to target.
 *
 *      Each number in candidates may only be used once in the combination.
 *
 *      Note: The solution set must not contain duplicate combinations.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        findCombination(ans, new LinkedList<>(), candidates, target, 0);

        return ans;
    }

    public void findCombination(List<List<Integer>> ans, List<Integer> path,
                                int[] candidates, int target, int start) {
        if (target == 0) {
            // 注意此处需要new一个list，因为list是引用类型，如果不new新的list会导致答案都为空
            ans.add(new LinkedList<>(path));
        } else if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                // 此处注意，画图便于理解
                if (i > start && candidates[i] == candidates[i-1]) continue;
                path.add(candidates[i]);
                findCombination(ans, path, candidates, target - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
