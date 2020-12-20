package array._73setMatrixZeroes;

import java.util.Arrays;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/9 18:19
 * @Description:
 *      Given an m x n matrix. If an element is 0, set its entire row and column
 *      to 0. Do it in-place.
 *
 *      Follow up:
 *
 *      1. A straight forward solution using O(mn) space is probably a bad idea.
 *      2. A simple improvement uses O(m + n) space, but still not the best solution.
 *      3. Could you devise a constant space solution?
 * Note: 标记是一种很好用的方法
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            Arrays.fill(matrix[0], 0);
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
