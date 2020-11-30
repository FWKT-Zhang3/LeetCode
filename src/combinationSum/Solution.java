package combinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/30 14:17
 * @Description: Given an array of distinct integers candidates and a target
 *      integer target, return a list of all unique combinations of candidates
 *      where the chosen numbers sum to target. You may return the combinations
 *      in any order.
 *
 *      The same number may be chosen from candidates an unlimited number of
 *      times. Two combinations are unique if the frequency of at least one of
 *      the chosen numbers is different.
 *
 *      It is guaranteed that the number of unique combinations that sum up to
 *      target is less than 150 combinations for the given input.
 *
 * Constraints:
 *
 *      1 <= candidates.length <= 30
 *      1 <= candidates[i] <= 200
 *      All elements of candidates are distinct.
 *      1 <= target <= 500
 */
public class Solution {
    /**
     * 别人的写法
     *
     * @param candidates the array to search
     * @param target the target integer
     * @return the matched combination
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                path.add(candidates[i]);
                findCombination(ans, path, candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
}
