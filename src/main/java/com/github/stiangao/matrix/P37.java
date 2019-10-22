package com.github.stiangao.matrix;

/**
 * 3ms
 */
public class P37 {

    int[] row = new int[10];
    int[] col = new int[10];
    int[][] box = new int[3][3];
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    place((board[i][j] - '0'), i, j);
                }
            }
        }
        recusiveSolveSudoku(board, 0, 0);
    }

    boolean couldPlace(int num, int i, int j) {
        int f = 1 << num;
        return (row[i] & f) == 0 && (col[j] & f) == 0 && (box[i / 3][j / 3] & f) == 0;
    }

    void place(int num, int i, int j) {

        board[i][j] = (char) ('0' + num);

        int f = 1 << num;
        row[i] |= f;
        col[j] |= f;
        box[i / 3][j / 3] |= f;
    }

    void backPlace(int num, int i, int j) {
        board[i][j] = '.';

        int f = 1 << num;
        row[i] &= ~f;
        col[j] &= ~f;
        box[i / 3][j / 3] &= ~f;
    }

    private boolean recusiveSolveSudoku(char[][] board, int i, int j) {
        if (j == 9) {
            j = 0;
            i++;
            if (i == 9) {
                return true;
            }
        }
        if (board[i][j] == '.') {
            for (int num = 1; num < 10; num++) {
                if (couldPlace(num, i, j)) {
                    place(num, i, j);

                    if (recusiveSolveSudoku(board, i, j + 1)) {
                        return true;
                    }
                    backPlace(num, i, j);
                }
            }
        } else {
            return recusiveSolveSudoku(board, i, j + 1);
        }
        return false;
    }
}
