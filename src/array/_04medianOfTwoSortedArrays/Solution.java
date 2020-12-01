package array._04medianOfTwoSortedArrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 * Note: Sorted的array如果没有特殊要求就直接搞到新array里就好
 * Created by Max Zhang on 2020/9/3.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;

        if (len == 0) {
            return 0;
        }

        int[] combined = new int[len];
        int a1 = 0, a2 = 0;

        for (int i = 0; i < len; i++) {
            if (a1 == nums1.length) {
                combined[i] = nums2[a2++];
            } else if (a2 == nums2.length) {
                combined[i] = nums1[a1++];
            } else if (nums1[a1] <= nums2[a2]) {
                combined[i] = nums1[a1++];
            } else {
                combined[i] = nums2[a2++];
            }
        }

        if (len % 2 == 0) {
            return (combined[len / 2 - 1] + combined[len / 2]) / 2d;
        } else {
            return combined[len / 2];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1, 2}, nums2 = {3};
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
