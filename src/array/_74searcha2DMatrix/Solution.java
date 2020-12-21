package array._74searcha2DMatrix;

/**
 * @Author: Max Zhang
 * @Date: 2020/12/21 15:36
 * @Description: Write an efficient algorithm that searches for a value in an
 *      m x n matrix. This matrix has the following properties:
 *
 *     * Integers in each row are sorted from left to right.
 *     * The first integer of each row is greater than the last integer of the
 *       previous row.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int[] ints : matrix) {
            if (target == ints[n - 1]) return true;
            if (target < ints[n - 1]) {
                for (int j : ints) {
                    if (j == target) return true;
                }
            }
        }
        return false;
    }
}
