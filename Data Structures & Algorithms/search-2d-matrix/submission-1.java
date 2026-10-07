class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int lp = 0, hp = cols - 1;
            while (lp <= hp) {/* while (lp < rp) skips the case where one element is left (lp == rp). For example, a row of size 1 never gets checked. Use <=.*/
                int mid = lp + (hp - lp) / 2; // avoids overflow
                int val = matrix[i][mid];
                if (val == target) {
                    return true;
                } else if (val < target) {
                    lp = mid + 1;
                } else {
                    hp = mid - 1;
                }
            }
        }
        return false;
    }
}