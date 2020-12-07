package array._31nextPermutation;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/27 14:34
 * @Description: Implement next permutation, which rearranges numbers into the
 *      lexicographically next greater permutation of numbers.
 *
 *      If such an arrangement is not possible, it must rearrange it as the
 *      lowest possible order (i.e., sorted in ascending order).
 *
 *      The replacement must be in place and use only constant extra memory.
 *
 * 算法推导：
 *      1. 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与
 *      前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大
 *      的数 123465。
 *
 *      2. 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。
 *      为了满足这个要求，我们需要：
 *          1. 在尽可能靠右的低位进行交换，需要从后向前查找
 *          2. 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该
 *          把 5 和 4 交换而不是把 6 和 4 交换
 *          3. 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。
 *          以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数
 *          重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下
 *          一个排列
 *
 * Note：一开始完全没有想法，思维混乱，没有条理。看了别人写的算法推导解析，很清晰明了。
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,4};
        Solution s = new Solution();
        s.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
