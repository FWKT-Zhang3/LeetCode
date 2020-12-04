package array._57insertInterval;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/4 15:52
 * @Description: Given a set of non-overlapping intervals, insert a new interval
 *      into the intervals (merge if necessary).
 *
 *      You may assume that the intervals were initially sorted according to
 *      their start times.
 *
 * Note: 这两种方法，运行速度和占用内存差不多，但是第二种方法明显更加简介，可读性更高，
 *      在答题之前应该多想想，不应该是有点想法就直接写，想一点写一点，缝缝补补，
 *      好好思考分析题目过后，再开始答题
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
//        // 自己的写法，比较乱，比较麻烦，
//        if (intervals == null || intervals.length == 0) return new int[][]{newInterval};
//
//        ArrayList<int[]> ans = new ArrayList<>();
//        int count = intervals.length;
//        boolean f = false;
//        for (int i = 0; i < intervals.length; i++) {
//            if (!f) {
//                if (intervals[i][1] < newInterval[0]) {
//                    ans.add(intervals[i]);
//                } else if (intervals[i][0] > newInterval[1]) {
//                    ans.add(newInterval);
//                    ans.add(intervals[i]);
//                    count += 1;
//                    f = true;
//                } else {
//                    intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
//                    intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
//                    ans.add(intervals[i]);
//                    for (int j = i + 1; j < intervals.length; j++) {
//                        if (intervals[j][1] > intervals[i][1]) {
//                            if (intervals[i][1] < intervals[j][0]) {
//                                count -= j - i;
//                                i = j - 1;
//                            } else {
//                                intervals[i][1] = intervals[j][1];
//                                count -= j - i;
//                                i = j;
//                            }
//                            break;
//                        }
//                        if (j == intervals.length - 1) {
//                            count -= j - i;
//                            i = j;
//                        }
//                    }
//                    f = true;
//                }
//            } else ans.add(intervals[i]);
//        }
//        if (!f) {
//            ans.add(newInterval);
//            count++;
//        }
//
//        return ans.toArray(new int[count][]);

        // 分成三种情况，重叠的部分之前，重叠的部分，和重叠的部分之后
        LinkedList<int[]> ans = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i++]);
        }

        // 关键部分，按照情况划分，共有六种情况，其中五种情况，intervals[i][0] <= newInterval[1]，
        // 而最后一种情况，新插入的interval在当前的interval之前，所以不用变化，直接把新的插入，
        // 所以这里使用了intervals[i][0] <= newInterval[1]为控制变量，而且while块主体内
        // 只改变newInterval的内容而不插入，在while块外面再插入，
        // 这样，就6种情况都包含了
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        ans.add(newInterval);

        while (i < intervals.length) ans.add(intervals[i++]);
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{0,5},
                new int[]{8,9},
        };
        Solution s = new Solution();
        int[][] ans = s.insert(arr, new int[]{3,4});
        for (int[] n : ans) {
            System.out.println(Arrays.toString(n));
        }
    }
}
