package leetcode;

/**
 * Created by ykp on 9/28/16.
 */
public class SudokuSolver37 {

    public void displayBoard(char[][] board){
        for(int i=0;i < board.length;i++){
            for(int j=0; j< board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public boolean solveSudoku(char[][] board){
        for(int i=0;i < board.length;i++){
            for(int j=0; j< board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9';k++){

                        if(isBoardValid(board,i,j,k)) {
                            board[i][j] = k;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBoardValid(char[][] board,int i, int j, char k){

        for(int row = 0; row < 9 ;row++){
            if(board[row][j] == k){
                return false;
            }
        }

        for(int col = 0; col < 9;col++){
            if(board[i][col] == k){
                return false;
            }
        }

        for(int a = (i/3)*3; a < ((i/3)*3)+3; a++){
            for(int b = (j/3)*3; b < ((j/3)*3)+3; b++){
                if(board[a][b] == k){
                    return false;
                }
            }
        }

        return true;
    }



    public static void main(String[] args){
        SudokuSolver37 sudoku = new SudokuSolver37();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}

        };
        if(sudoku.solveSudoku(board)){
            sudoku.displayBoard(board);
        }
    }
}
