package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */
/************************************************************************************************
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 *
 * We get the following sequence (ie, for n = 3):
        "123"
        "132"
        "213"
        "231"
        "312"
        "321"

 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 ************************************************************************************************/

import java.util.ArrayList;
import java.util.List;

/**
 * sort??? every time add the element???
 * is it based on the next permutation???
 *
 * solution one: brute force: find all the permutation and then sort the reselt to get the kth ! TimeLimitExceed
 *
 * solution two:
 * we can find that the n number permutation is the first digis + the rest (n - 1) digits' permutation (n - 1)!
 *
 * so when each number at the first position, will have (n - 1)! possible permutation!
 *
 * so each start position digit will in the (n - 1)! groups
 *
 * we use k/(n - 1), thus we can get the first digits !
 *
 * eg: you have 10 groups, each group have 5 elements, so the 21th elements is 21/5 = 4, in the 4th group
 *
 * kth, begin at 0 or 1??  ---> begin at 1
 *
 *
 * n = 3,  k = 1, the first number is k/2! = 1/2 = 0,  not apply to 123, so we take (k-1)/2! + 1 = 1, works
 *         k = 2, the first number is k/2! = 2/2 = 1,
 *         k = 3, the first number is k/2! = 3/2 = 1,
 *         k = 4, the first number is k/2! = 4/2 = 2,
 *         k = 5, the first number is k/2! = 5/2 = 2,
 *
 * so the kth element's highest number is (k-1)/(n - 1)! + 1,  and then we update the value of n and k
 *
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n < 1 || n > 9 || k < 0) {
            return "";
        }

        int factorial = 1;  // the factorial of n - 1
        List<Integer> notUsed = new ArrayList<Integer>();  // notUsed is the number that not been add in the result
        for (int i = 1; i <= n; i ++) {
            notUsed.add(i);  // add number i in the arraylist
            if (i == n) {  // factorial is the factorial of (n - 1), so cannot multiple n
                break;
            }
            factorial *= i;
        }

        String result = "";  // empty string to keep the result
        k = k - 1;    // beign at 0, since the arraylist index starts at 0,

        while(true) {
            result += notUsed.remove(k / factorial);  // after remove the element, the position of the number will also be changed,   eg: if k = 1, n = 3. notUsed.get(0)  = 1; remove(0), then notUsed(0) = 2
            k = k % factorial;
            if (notUsed.isEmpty()) {
                break;
            }
            factorial = factorial/ notUsed.size();  // notUsed.size() equal to (n - 1) !  so we can get the next factorial value
        }
        return result;
    }
}
