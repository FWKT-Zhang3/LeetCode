package array._59spiralMatrix2;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/4 18:21
 * @Description: Given a positive integer n, generate an n x n matrix filled
 *      with elements from 1 to n2 in spiral order.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};
        int[][] ans = new int[n][n];
        int rStart = 0, cStart = 0, rEnd = n - 1, cEnd = n - 1, temp = 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int i = cStart; i <= cEnd; i++) {
                ans[rStart][i] = temp++;
            }
            rStart++;

            for (int i = rStart; i <= rEnd; i++) {
                ans[i][cEnd] = temp++;
            }
            cEnd--;

            if (rStart < rEnd) {
                for (int i = cEnd; i >= cStart; i--) {
                    ans[rEnd][i] = temp++;
                }
                rEnd--;
            }

            if (cStart <= cEnd) {
                for (int i = rEnd; i >= rStart; i--) {
                    ans[i][cStart] = temp++;
                }
                cStart++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] c = s.generateMatrix(5);
        for (int[] a : c) {
            System.out.println(Arrays.toString(a));
        }
    }
}
