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

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;
                int val = board[r][c] - '0';
                int box = (r / 3) * 3 + c / 3;
                if (!rows[r].add(val) || !cols[c].add(val) || !boxes[box].add(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
