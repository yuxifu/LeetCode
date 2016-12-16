/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-15
 */
/*
   Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
   The Sudoku board could be partially filled, where empty cells are filled
   with the character '.'.
 */


import java.util.*;

public class ValidSudoku {

// Time: o(9^2)
// Space: o(9)
public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];

        //check rows and columns
        for(int i=0; i<9; i++) {
                Arrays.fill(used,false);
                for(int j = 0; j<9; j++) {
                        if(check(board[i][j],used)==false) return false;
                }
                Arrays.fill(used,false);
                for(int j = 0; j<9; j++) {
                        if(check(board[j][i],used)==false) return false;
                }
        }

        //check individual 3x3 sub-board
        for(int r = 0; r<3; r++) {
                for(int c = 0; c<3; c++) {
                        Arrays.fill(used,false);
                        for(int i = r*3; i<r*3+3; i++) {
                                for(int j = c*3; j<c*3+3; j++) {
                                        if(check(board[i][j],used)==false) return false;
                                }
                        }
                }
        }
        return true;
}
boolean check(char ch, boolean[] used){
        if(ch=='.') return true;
        if(used[ch-'1']) return false;
        used[ch-'1']=true;
        return true;
}

// debug
public static void main(String[] args) {
        ValidSudoku s = new ValidSudoku();
}
}
