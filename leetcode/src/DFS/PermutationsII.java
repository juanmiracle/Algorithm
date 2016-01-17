package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*************************************************************************************************
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 *
 * [1,1,2] have the following unique permutations:
 *
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 *************************************************************************************************/

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);  //sort the array, in case of duplicate elements
        boolean[] used = new boolean[nums.length];      // check whether this element has been used
        List<Integer> list = new ArrayList<Integer>();
        permuteHelper(nums,result, list, used);
        return result;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i= 0; i < nums.length; i ++) {
            if (used[i]) continue;   // if nums[i] has been used, then continue
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            permuteHelper(nums, result, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
