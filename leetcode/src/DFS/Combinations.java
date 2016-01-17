package DFS;

/**
 * Created by JuanLi on 1/17/16.
 */


import java.util.ArrayList;
import java.util.List;

/**********************************************************************************
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 *
 * If n = 4 and k = 2, a solution is:
 *
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 **********************************************************************************/


public class Combinations {
    public static  List<List<Integer>> combine(int n, int k) {
        //create the return type variable
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // base case
        if (n == 0 || k <= 0) {
            return result;
        }

        // createt the array list to keep possible solution
        List<Integer> list = new ArrayList<Integer>();

        // call the sub function
        combineHelper(n, 1, k, result, list);
        return result;
    }

    public static void combineHelper(int endNum, int current, int comNum, List<List<Integer>> result, List<Integer> list) {
        if (comNum == 0) {                // if all comNum had been conbined, then stop add more elememnt
            result.add(new ArrayList<Integer>(list));   // add list into result;
            return;     // void type, return null
        }

        // if the list has the number that kess than comNum, add current  element
        list.add(current);   // current range form 1 to n(endNum)
        combineHelper(endNum, current+1, comNum - 1, result, list);
        list.remove(list.size() - 1);   // like DFS

        // if has added comNum  then return

        if (endNum - current + 1 == comNum) {
            return;
        }

        // else ingorn the current value for the recurrence

        combineHelper(endNum, current + 1, comNum, result, list);



    }

    public static void main(String[] args) {
        int n  =4, k = 2;
        System.out.println(combine(n, k));
    }
 }
