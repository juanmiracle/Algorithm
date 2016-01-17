package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JuanLi on 1/17/16.
 */

/*************************************************************************************************
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 *
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
*************************************************************************************************/

/**
 * we need to map the digit with letters!!!
 * the out come is the String!!!  how to modify String, since string is immutable
 */

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        // base boundary case
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        // set the map with digit to letters
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();  // StringBuilder can let use modify the string!since sting is immutable

        letterHelper(digits, result, sb, map, 0);
        return result;
    }

    public void letterHelper(String digits, List<String> result, StringBuilder sb, HashMap<Integer, String> map, int start) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letter = map.get(digits.charAt(start) - '0');  // get the letters that the digit stands for
        char[] letters = letter.toCharArray();  // convert the string to char array

        for (char c : letters) {
            sb.append(c);    // add c  to the sb
            letterHelper(digits, result, sb, map, start+1);
            sb.deleteCharAt(start);  // delete c
        }
    }
}
