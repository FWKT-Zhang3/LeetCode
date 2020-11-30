package searchInRotatedSortedArray;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/28 03:58
 * @Description: You are given an integer array nums sorted in ascending order,
 *      and an integer target.
 *
 *      Suppose that nums is rotated at some pivot unknown to you beforehand
 *      (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 *      If target is found in the array return its index, otherwise, return -1.
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 自己的写法，按照情况分类迭代寻找，
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) {
            if (target == nums[0]) return 0;
            else return -1;
        }
        int mid, head = 0, tail = nums.length - 1;

        while (head < tail) {
            mid = (tail + head) / 2;
            if (target == nums[head]) return head;
            if (target == nums[tail]) return tail;
            if (target == nums[mid]) return mid;
            if (head == mid) return -1;

            // 每次找确定的升序部分
            // head, mid, tail 按情况分为
            // 1. 小 中 大：12345678
            // 2. 中 大 小：45678123
            // 3. 大 小 中：67812345
            // 其中，1,2情况相同，判断target是否在前一半
            // 第3种情况判断target是否在后一半
            if (nums[head] >= nums[mid] && nums[mid] <= nums[tail]) {
                if (target > nums[mid] && target < nums[tail]) head = mid;
                else tail = mid;
            } else {
                if (target > nums[head] && target < nums[mid]) {
                    tail = mid;
                } else head = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4,5,6,7,8,1,2,3}, 8));
    }
}
