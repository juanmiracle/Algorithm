package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */

import java.util.ArrayList;
import java.util.List;

/*************************************************************************************************
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Ensure that numbers within the set are sorted in ascending order.
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 *
 * Output:
 *
 * [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 *************************************************************************************************/

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 1 && k > n) {
            return result;
        }

        comHelper(k, n, 1, result, new ArrayList<Integer>());
        return result;
    }

    public void comHelper(int k, int sum, int start, List<List<Integer>> result, List<Integer> list) {
        if (k == 0 && sum == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        } else if (k < 0 || sum < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {   // be careful with the start point !!! 
            list.add(i);
            comHelper(k - 1, sum - i, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
