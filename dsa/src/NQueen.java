import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();
        for(int i = 0 ; i < board.length;i++) {
            String s = new String(board[i]);
            temp.add(s);
        }
        return temp;
    }


    public boolean validate(char[][] board, int col, int row) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    public  void solveNQueensHelper(int col, char[][] board, List<List<String>> output) {

        if(col == board.length) {
            output.add(construct(board));
            return;
        }
        for(int row = 0; row < board.length ; row++) {
            if(validate(board,col,row)) {
                board[row][col] = 'Q';
                solveNQueensHelper(col+1,board,output);
                board[row][col] = '.';
            }
        }
    }
    class Solution {
        public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
            char[][] board = new char[n][n];
            for(int i = 0; i < n ; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }

            solveNQueensHelper(0,board,output);
            return output;
        }
    }
}











