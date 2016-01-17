package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**************************************************************************************************
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 *
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 2,3,6,7 and target 7,
 *
 * A solution set is:
 *
 * [7]
 *
 * [2, 2, 3]
 **************************************************************************************************/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }

        List<Integer> list = new ArrayList<Integer>();
        //sort array, so we get the output in non-descending order, and avoid the duplicate answer
        Arrays.sort(candidates);
        combineHelper(candidates, 0,target, result, list);
        return result;
    }

    public void combineHelper(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> list) {
        // if (target == 0) {  // if the sum equals to the sum, add the list in result
        //     result.add(new ArrayList<Integer>(list));  // ??? why need to new a new list ???
        //     return;
        // } else if (target < 0) {
        //     return;
        // }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < target) {    // if current candidated < target, then we can add it in the waiting list
                list.add(candidates[i]);
                combineHelper(candidates, i ,target - candidates[i], result, list);
                list.remove(list.size() - 1);
            } else if (candidates[i] == target) {
                list.add(candidates[i]);
                result.add(new ArrayList<Integer>(list));  // why we need the new one???
                list.remove(list.size() - 1);  // remove !!!  why need remove !!!
            }
        }

    }
}
