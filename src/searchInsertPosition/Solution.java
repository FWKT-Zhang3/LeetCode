package searchInsertPosition;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/30 13:54
 * @Description: Share
 * Given a sorted array of distinct integers and a target value, return the
 *      index if the target is found. If not, return the index where it would be
 *      if it were inserted in order.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        //自己的写法，我是傻逼
        if (nums == null || nums.length == 0) return 0;
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int head = 0, tail = nums.length - 1;
        int mid;
        while (head < tail) {
            mid = (head + tail) / 2;

            if (target == nums[head]) return head;
            else if (target == nums[tail])
                return search(nums, tail - 1, target, 1);
            else if (target == nums[mid])
                return search(nums, mid - 1, target, 1);

            if (head == mid) {
                if (target > nums[head]) return tail;
                else return head;
            }

            if (target > nums[mid]) head = mid;
            else tail = mid;
        }

        return -1;

        //简单的写法
        //在本题中，这个写法没问题，都是0ms，但是这个算法是O(n)，
        //如果数据量大，而且位置在最后的话，就会花费很多时间
//        for(int i = 0; i < nums.length; i++){
//            if(target <= nums[i]) return i;
//        }
//        return nums.length;

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
