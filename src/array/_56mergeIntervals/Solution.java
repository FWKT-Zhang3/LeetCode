package array._56mergeIntervals;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/3 17:18
 * @Description: Given an array of intervals where intervals[i] = [starti, endi],
 *      merge all overlapping intervals, and return an array of the
 *      non-overlapping intervals that cover all the intervals in the input.
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
//        // 自己的写法，很慢
//        // 因为排了一次序，然后遍历，然后再用toArray方法变成二维数组，
//        // 这种写法思路简单
//        if (intervals == null) return null;
//        if (intervals.length <= 1) return intervals;
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        List<int[]> a = new ArrayList<>();
//        int[] temp = intervals[0];
//        a.add(temp);
//        for (int[] cur : intervals) {
//            if (cur[0] <= temp[1]) {
//                temp[1] = Math.max(temp[1], cur[1]);
//            } else {
//                temp = cur;
//                a.add(temp);
//            }
//        }
//
//        return a.toArray(new int[a.size()][]);

        // 另一种思路，遍历第一遍的时候做标记，遍历第二次吧元素添加到新数组
        int len = intervals.length, count = len, idx = 0;
        for (int i = 0; i < len - 1; i++) {
            int[] s1 = intervals[i];
            for (int j = i + 1; j < len; j++) {
                int[] s2 = intervals[j];
                if (s1[0] <= s2[1] && s2[0] <= s1[1]) {
                    s2[0] = Math.min(s1[0], s2[0]);
                    s2[1] = Math.max(s1[1], s2[1]);
                    s1[0] = 1;
                    s1[1] = 0;
                    count--;
                    break;
                }
            }
        }
        int[][] res = new int[count][];
        for (int[] interval : intervals) {
            if (interval[1] < interval[0]) {
                continue;
            }
            res[idx++] = interval;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = new int[][]{
                new int[]{2,3},
                new int[]{4,5},
                new int[]{6,7},
                new int[]{8,9},
                new int[]{1,10},
        };
        int[][]c = s.merge(a);
        for (int[] b: c) {
            System.out.println(Arrays.toString(b));
        }
    }
}
