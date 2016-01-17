package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */

/*************************************************************************************************
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 *
 * [1,2,3] have the following permutations:
 *
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 *************************************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * permutation:  distinct number!!!
 *
 * the difference  between conbination and the permutation:whether take the order of the list into account
 *
 *
 *
 * */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permuteHelper(nums, result, new ArrayList<Integer>());
        return result;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (!list.contains(nums[i])) {  // the order to add the elememnt!!!
                list.add(nums[i]);
                permuteHelper(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

}
