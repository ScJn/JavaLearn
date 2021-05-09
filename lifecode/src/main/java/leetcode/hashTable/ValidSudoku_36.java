package leetcode.hashTable;

import java.util.HashSet;

/**
 * thinking: judge if there is duplicate. use set,
 * convert the state(in concrete problem) to String is a good solution.
 *
 */
public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {

                    if (!set.add(board[i][j] + "R" + i) || !set.add(board[i][j] + "C" + j) || !set.add(board[i][j] + "" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
