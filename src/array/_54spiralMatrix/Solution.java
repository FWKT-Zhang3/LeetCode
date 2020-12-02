package array._54spiralMatrix;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/2 17:28
 * @Description: Given an m x n matrix, return all elements of the matrix
 *      in spiral order.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;

        int rowStart = 0, rowEnd = matrix.length - 1,
                colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ans.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return ans;
    }
}
