package twoSum;

import java.util.HashMap;

/**
 * Created by Max Zhang on 2020/9/3.
 *
 * 比使用for loop嵌套快了很多
 *
 * Time Submitted | Status | Runtime | Memory | Language
 * 09/03/2020 12:17	Accepted	1 ms	39.4 MB	java
 * 09/03/2020 11:50	Accepted	91 ms	40.9 MB	java
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int diff;
        for(int i = 0; i < len; i++) {
            diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
