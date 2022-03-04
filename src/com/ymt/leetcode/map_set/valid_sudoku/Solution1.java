package com.ymt.leetcode.map_set.valid_sudoku;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 *
 * @author yumingtao
 * @date 2022/3/4 10:16
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Character> rowMap = new HashMap<>();
        Map<String, Character> colMap = new HashMap<>();
        Map<String, Character> gridMap = new HashMap<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                String rowKey = getRowKey(i, board[i][j]);
                String colKey = getColKey(j, board[i][j]);
                String gridKey = getGridKey(i, j, board[i][j]);
                if (rowMap.containsKey(rowKey) || colMap.containsKey(colKey) || gridMap.containsKey(gridKey)) {
                    return false;
                }
                rowMap.put(rowKey, board[i][j]);
                colMap.put(colKey, board[i][j]);
                gridMap.put(gridKey, board[i][j]);
            }
        }
        return true;
    }

    private String getRowKey(int row, char ch) {
        return row + "_" + ch;
    }

    private String getColKey(int col, char ch) {
        return col + "_" + ch;
    }

    private String getGridKey(int row, int col, int ch) {
        return row / 3 + "_" + col / 3 + "_" + ch;
    }
}
