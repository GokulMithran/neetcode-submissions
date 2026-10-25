class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new Set[9];
        Set<Integer>[] cols = new Set[9];
        Set<Integer>[] boxes = new Set[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.')
                    continue;
                int val = board[row][col] - '0';
                int box = (row / 3 * 3) + col / 3;

                if(!rows[row].add(val) || !cols[col].add(val) || !boxes[box].add(val)){
                    return false;
                }
            }
        }
        return true;
    }
}
