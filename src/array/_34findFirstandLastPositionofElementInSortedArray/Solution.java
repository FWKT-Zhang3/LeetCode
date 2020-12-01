package array._34findFirstandLastPositionofElementInSortedArray;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/30 13:01
 * @Description: Given an array of integers nums sorted in ascending order, find
 *      the starting and ending position of a given target value.
 *
 *      If target is not found in the array, return [-1, -1].
 *
 *
 */
public class Solution {
    /**
     * 自己的写法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find
     *      First and Last Position of Element in Sorted Array.
     * Memory Usage: 42 MB, less than 92.27% of Java online submissions for
     *      Find First and Last Position of Element in Sorted Array.
     *
     * @param nums the array to search
     * @param target the target number
     * @return the index pair of matching ([starting, ending]),
     *          If target is not found in the array, return [-1, -1].
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0,0};
            else return new int[]{-1, -1};
        }
        if (target < nums[0]
                || target > nums[nums.length - 1]) return new int[]{-1, -1};

        int head = 0, tail = nums.length - 1, len = nums.length;

        while (head < tail) {
            int mid = (head + tail) / 2;

            if (target == nums[head]) {
                return new int[]{head, search(nums, head + 1, target, 0)};
            }
            if (target == nums[tail]) {
                return new int[]{search(nums, tail - 1, target, 1), tail};
            }
            if (target == nums[mid]) {
                return new int[]{search(nums, mid - 1, target, 1),
                        search(nums, mid + 1, target, 0)};
            }

            if (head == mid) return new int[]{-1, -1};

            if (target < nums[mid]) {
                tail = mid;
            } else {
                head = mid;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * Auxiliary funciton to search the starting or ending position
     *
     * @param nums the array to search
     * @param index the index of position to start matching
     * @param target the target number
     * @param direction the searching direction, 0 for ascending index,
     *                  otherwise for descending index
     * @return the index of last matching
     */
    public int search(int[] nums, int index, int target, int direction) {
        int i = index;
        if (direction == 0) {
            for ( ; i < nums.length; i++) {
                if (nums[i] != target) {
                    return i - 1;
                } else {
                    if (i == nums.length - 1) return i;
                }
            }
        } else {
            for ( ; i >= 0; i--) {
                if (nums[i] != target) {
                    return i + 1;
                } else {
                    if (i == 0) return 0;
                }
            }
        }
        return i;
    }
}
