public class Driver {
    public void nQueenMethod(){
        NQueen.Solution solution = new NQueen().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    public void subsetMethod(){
        Subset.Solution solution = new Subset().new Solution();
        System.out.println(solution.subsets(new int[] {1,2,3,4}));
    }

    public void sudokuMethod() {
        Sudoku.Solution solution = new Sudoku().new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.sudoku(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
       Driver driver = new Driver();
       //driver.subsetMethod();
      // driver.nQueenMethod();
       driver.sudokuMethod();;

    }
}


