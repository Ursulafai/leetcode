import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        int boxIndex;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    boxIndex = r / 3 * 3 + c / 3;

                    if (rows[r].contains(board[r][c]) || columns[c].contains(board[r][c]) ||
                            boxes[boxIndex].contains(board[r][c])) return false;

                    rows[r].add(board[r][c]);
                    columns[c].add(board[r][c]);
                    boxes[boxIndex].add(board[r][c]);
                }
            }
        }

        return true;

    }

}
