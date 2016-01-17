package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*************************************************************************************************
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 *
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 *
 * [1, 2, 5]
 *
 * [2, 6]
 *
 * [1, 1, 6]
 *
 *************************************************************************************************/

/* *
 * CombinationSumI we allow duplicate element in one solution, this one every element appear at most once in one solution
 *
 *
 * */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }

        Arrays.sort(candidates);
        combineHelper(candidates, 0, target, result, new ArrayList<Integer>());

        return result;
    }

    public void combineHelper(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {  // sum == target, add it to result
            result.add(new ArrayList<Integer>(list));
            return;
        } else if (target < 0) {  // if target < 0, no
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i-1]) { // remove duplicate element
                continue;
            }

            list.add(candidates[i]);
            combineHelper(candidates, i + 1, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
    }
}
