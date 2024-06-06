public class Sudoku {
    public class Solution {
        public boolean validate(int row , int col, int val,char[][] board) {
            for(int i = 0; i < 9; i++) {
                if(board[row][i] == val) return false;
                if(board[i][col] == val) return false;
                if(board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == val) return false;
            }
            return true;
        }
        public boolean sudoku(char[][] board) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board.length; j++) {
                    if(board[i][j] == '.') {
                        for(char k = '1'; k <= '9'; k++) {
                            if (validate(i, j, k, board)) {
                                board[i][j] =  k;
                                if (sudoku(board)) {
                                    return true;
                                } else {
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
             }
            return true;
        }
    }
}
