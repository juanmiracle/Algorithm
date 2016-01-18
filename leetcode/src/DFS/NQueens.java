package DFS;

/**
 * Created by JuanLi on 1/18/16.
 */

/************************************************************************************************
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 *
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
************************************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * how to define the 8 direction??? to check collision
 * 1. boolean mark all the place after add the queen
 * 2. very good idea !!!!  since each row, the queen is unique, so we can use a one demension array to keep the position! !!!
 * use this array, there is no need to remove, we can back the original row the find the next position!
 * 3.search row by row, if the row = n, then all n queens are in place
 *
 */

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<List<String>>();
        if (n < 0) return solution;

        int[] columnValue = new int[n];  //column value of each row, get Queen's position, columnValue[0]-> (0,columnValue[0] )
        // DFS to search all the possible solution !!!
        solveDFS(columnValue, 0, n, solution);
        return solution;
    }

    public void solveDFS(int[] columnValue, int row, int n, List<List<String>> solution) {
        if (row == n) { // if the row == n, means all n queens are in placed
            String[] place = new String[n];
            List<String> list = new ArrayList<String>();
            for (int nrow = 0; nrow < n; nrow ++) {
                StringBuilder sb = new StringBuilder();
                for (int ncol = 0; ncol < n; ncol ++) {
                    if (columnValue[nrow] == ncol) {  // columnValue[nrow] == ncol -> (nrow, ncol) = Q
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }   //finish each row
                place[nrow] = sb.toString();
                list.add(place[nrow]);
            }
            solution.add(list);
        } else {   // if row != n, the search doesn't finish
            //columnValue[row]
            for(int ncol = 0; ncol < n; ncol ++) {
                columnValue[row] = ncol;
                if (isValid(columnValue, row)) {  // if this place is safe to place the queen
                    solveDFS(columnValue, row + 1, n, solution); // search the new row
                }
            }
        }
    }

    public boolean isValid(int[] columnValue, int row) {
        for (int i = 0; i < row; i ++) {  // check whether in the same column or diagonal with the already palced queen
            if (columnValue[i] == columnValue[row] || (row - i) == Math.abs(columnValue[row] - columnValue[i])) {
                return false;
            }  // digonal: the difference between the rows = difference between the column -> same diagonal
        }   //columnValue(i) == cloumnValue(row)   the rowth row and ith row in the same cloumn
        return true;
    }
}
