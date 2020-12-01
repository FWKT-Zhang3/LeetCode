package array._45jumpGame2;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/1 15:54
 * @Description: Given an array of non-negative integers nums, you are
 *      initially positioned at the first index of the array.
 *
 *      Each element in the array represents your maximum jump length at
 *      that position.
 *
 *      Your goal is to reach the last index in the minimum number of jumps.
 *
 *      You can assume that you can always reach the last index.
 */
public class Solution {
    public int jump(int[] nums) {
//        // 自己的写法，算法复杂度很高，超出时限
//        if (nums == null || nums.length == 1) return 0;
//
//        List<List<Integer>> arr = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        jumpStep(arr, path, nums, 0, nums.length - 1);
//
//        if (arr.size() == 0) return 0;
//
//        int min = arr.get(0).size();
//        for (List<Integer> l : arr) {
//            min = Math.min(min, l.size());
//        }
//
//        return min;

        // The main idea is based on greedy. Let's say the range of the current
        // jump is [curBegin, curEnd], curFarthest is the farthest point that
        // all points in [curBegin, curEnd] can reach. Once the current point
        // reaches curEnd, then trigger another jump, and set the new curEnd
        // with curFarthest, then keep the above steps, as the following:
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }

        return jumps;

        // the version that consider the condition that can't reach the end
//        int jumps = 0, curEnd = 0, curFarthest = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > curFarthest) return -1;
//            curFarthest = Math.max(curFarthest, i + nums[i]);
//            if (i < nums.length - 1 && i == curEnd) {
//                jumps++;
//                curEnd = curFarthest;
//            }
//        }
//
//        return jumps;
    }

    /*
     * 自己写法的辅助函数
     */
//    public void jumpStep(List<List<Integer>> arr, List<Integer> path,
//                         int[] nums, int start, int target) {
//        if (target == 0) {
//            arr.add(new ArrayList<>(path));
//        } else if (target > 0) {
//            if (nums[start] > 0) {
//                for (int i = 1; i <= nums[start]; i++) {
//                    path.add(i);
//                    jumpStep(arr, path, nums, start + i,target - i);
//                    path.remove(path.size() - 1);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[]{2,9,6,5,7,0,7,2,7,9,3,2,2,5,7,8,1,6,6,6,3,5,2,2,6,3}));
    }
}
