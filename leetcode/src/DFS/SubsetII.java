package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/************************************************************************************************
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 * Note:
 *
 * Elements in a subset must be in non-descending order.
 *
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 *
 * If nums = [1,2,2], a solution is:

        [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
        ]
 ************************************************************************************************/

/**
 * duplicate elements???  how to deal with thses elements
 *
 * [1,1] wrong answer!!!
 *  // if (i > 0 && nums[i] == nums[i - 1] && nums[i]!=nums[position]) this one is not working for the duplicate elements
 *
 *   if(i != position && nums[i] == nums[i - 1])
 */

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums); // deal with the duplicate elements
        List<Integer> list = new ArrayList<Integer>();
        subsetHelper(nums, result, list, 0);
        return result;
    }

    public void subsetHelper(int[] nums, List<List<Integer>> result, List<Integer> list, int position) {
        result.add(new ArrayList<Integer>(list));

        for (int i = position; i < nums.length; i ++) {
            // if (i > 0 && nums[i] == nums[i - 1] && nums[i]!=nums[position]){
            if(i != position && nums[i] == nums[i - 1]) {
                continue;  // skip the duplicate element  !!!   nums[i]!=nums[position]
            }
            list.add(nums[i]);
            subsetHelper(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
