package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuanLi on 1/17/16.
 */
/*************************************************************************************************
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note:
 *
 * Elements in a subset must be in non-descending order.
 *
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 *
 * If nums = [1,2,3], a solution is:

        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]
 *************************************************************************************************/

/***
 * subset is similar to the combination problem, the difference is the length of the subset various!!!
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<Integer>();
        // result.add(list);   // the null subset
        subsetHelper(nums, result, list, 0);
        return result;
    }

    public void subsetHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int position) {
        result.add(new ArrayList<Integer>(list));
        for (int i = position; i < nums.length; i ++) {   // also need a index to track the current position
            list.add(nums[i]);
            subsetHelper(nums, result, list, i + 1);   // i + 1, not position + 1 !!!!!
            list.remove(list.size() - 1);
        }
    }
}
