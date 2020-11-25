package containerWithMostWater;

/**
 * @Author: Max Zhang
 * @Date: 2020/11/24 21:56
 * @Description: Given n non-negative integers a1, a2, ..., an , where each
 * represents a point at coordinate (i, ai). n vertical lines are drawn such
 * that the two endpoints of the line i is at (i, ai) and (i, 0). Find two
 * lines, which, together with the x-axis forms a container, such that the
 * container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 * Time Submitted   Status  Runtime Memory  Language
 * 11/25/2020 14:38	Accepted	1 ms	40.6 MB	java
 * 11/25/2020 14:32	Accepted	2 ms	40.5 MB	java
 * 11/24/2020 22:05	Accepted	588 ms	40.4 MB	java
 */
public class Solution {
    public int maxArea(int[] height) {
        // 自己的写法，算法复杂度O(n^2)
        // 很复杂，但是思路很简单
//        int water = 0, h;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i; j < height.length; j++) {
//                h = Math.min(height[i], height[j]);
//                if ((j - i) * h > water) {
//                    water = (j - i) * h;
//                }
//            }
//        }
//        return water;

        // O(n)写法
        // 只考虑结果可能更大的情况，不计算结果小的情况
//        int left = 0, right = height.length-1;
//        int max = 0;
//        while (left < right) {
//            max = Math.max(max,
//                    Math.min(height[left], height[right]) * (right-left));
//            if (height[left] < height[right]) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return max;

        // O(n)算法的改进
        // 在移动指针时，只考虑指针指向的值比原始值大的情况，只有新指向的值值原始值大，
        // 才有可能得到更大的结果
        int left = 0, right = height.length-1;
        int max = 0;
        while (left < right) {
            max = Math.max(max,
                    Math.min(height[left], height[right]) * (right-left));
            if (height[left] < height[right]) {
                int pre = height[left];
                while (height[left] <= pre && left < right) {
                    left++;
                }
            } else {
                int pre = height[right];
                while (height[right] <= pre && left < right) {
                    right--;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{4,3,2,1,4}));
    }
}
