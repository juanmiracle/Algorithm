package DFS;

import java.util.Arrays;

/**
 * Created by JuanLi on 1/17/16.
 */
/*************************************************************************************************
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1
 *************************************************************************************************/

/**
 * The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.
 * Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 * Find the largest index l greater than k such that a[k] < a[l].
 * Swap the value of a[k] with that of a[l].
 * Reverse the sequence from a[k + 1] up to and including the final element a[n].
 */



public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
                return;
        }
        int len = nums.length;

            // find the largest index k that a[k] < a[k + 1]
        int maxK = -1;
        for ( int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                maxK = Math.max(maxK, i);
            }
        }
            // if no such index exists, then this is the last permutation! so the next one is sorted the array
        if ( maxK == -1) {
            Arrays.sort(nums);
            return;
        }

        // find the largest index l greater that maxK suck taht a[k] = a[l]
        int maxL = 0;
        for (int i = len - 1; i > 0; i --) {
            if (nums[i] > nums[maxK]) {  // the first element that larger than nums[maxK] is the largest index, so beign at tail
                maxL = i;
                break;
            }
        }

         // swap the value of nums[maxK] and nums[maxL]
        swap(nums, maxK, maxL);

            // reverse the sequence from a[maxK + 1] to a[n]
        if (len - maxK <= 1) {
            return;
        } else {
            reverse(nums, maxK + 1, len -1);
        }

        return;
    }

        // swap the index of  left and right in nums
        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        public void reverse(int[] nums, int start, int end) {
            while(start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end --;
                start ++;
            }
        }
}
