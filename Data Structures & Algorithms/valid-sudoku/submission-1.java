
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create 9 sets for rows, 9 for cols, and 9 for 3x3 sub-boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Skip empty cells
                if (val == '.') {
                    continue;
                }

                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the digit is already in the set, it's an invalid board
                if (!rows[r].add(val) || !cols[c].add(val) || !boxes[boxIndex].add(val)) {
                    return false;
                }
            }
        }

        return true;
    }
}