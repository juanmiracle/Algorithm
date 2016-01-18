package DFS;

/**
 * Created by JuanLi on 1/18/16.
 */

/************************************************************************************************
 *
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 ************************************************************************************************/

/**
 * are there any fatser solution for this one!!  or modify the N-Queens problem, to count the number???
 * 1. solution one:  modify the N-Queens problem, to count the solution!!!
 * 2. want to use a int to count the solution number, but the value can not be passed back
 * !!! be careful Pass by value versus pass by reference
 */

public class NQueensII {

        public int totalNQueens(int n) {
            if (n <= 0) return 0;

            int[] colValue = new int[n];
            int[] count = new int[1];  // define a array to keep the total count
            dfsHelper(n, 0, count, colValue);

            return count[0];
        }

        public void dfsHelper(int n, int row, int[] count, int[] colValue) {
            if (row == n) { // all the n queens are in place
                count[0] ++;   // count ++
            } else {
                for (int col = 0; col < n; col ++) {
                    colValue[row] = col;  // palce in (row, col)
                    if (isValid(colValue, row)) {
                        dfsHelper(n, row + 1, count, colValue);
                    }
                }
            }
        }

        public boolean isValid(int[] colValue, int row) {
            for (int i = 0; i < row; i++) {
                if (colValue[i] == colValue[row] || Math.abs(colValue[i] - colValue[row]) == (row - i)) {
                    return false;
                }
            }
            return true;
        }
}
