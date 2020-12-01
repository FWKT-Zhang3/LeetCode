package array._42trappingRainWater;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/1 14:21
 * @Description: Given n non-negative integers representing an elevation map
 *      where the width of each bar is 1, compute how much water it can trap
 *      after raining.
 */
public class Solution {
    public int trap(int[] height) {
        //自己的写法，慢的一批，复杂度O(n^2)
//        if (height == null || height.length <= 2) return 0;
//        int ori = 0, crr = 0;
//
//        for (int num : height) {
//            ori += num;
//        }
//
//        for (int i = 0; i < height.length; i++) {
//
//            if (height[i] > 0) {
//                int temp = i + 1, max = Integer.MIN_VALUE, tempIndex = i;
//                while (temp < height.length) {
//                    if (height[temp] >= height[i]) {
//                        int t = height[i];
//                        while (i < temp) {
//                            if (height[i] < t) height[i] = t;
//                            i++;
//                        }
//                        i = temp - 1;
//                        break;
//                    } else {
//                        if (height[temp] >= max) {
//                            max = height[temp];
//                            tempIndex = temp;
//                        }
//                    }
//                    temp++;
//                }
//                int e = i;
//                while (e < tempIndex) {
//                    height[e] = Math.max(height[e], height[tempIndex]);
//                    e++;
//                }
//            }
//        }
//
//        for (int num : height) {
//            crr += num;
//        }
//
//        return crr - ori;

        // 大佬的写法，又快又简洁
        // 我是傻逼
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{5,4,1,2}));
    }
}
