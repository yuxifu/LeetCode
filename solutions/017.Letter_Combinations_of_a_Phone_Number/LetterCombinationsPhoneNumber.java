/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-05
 */
/*
   Given a digit string, return all possible letter combinations that the
   number could represent.
   A mapping of digit to letters (just like on the telephone buttons)
   is given below.
   Input:Digit string "23"
   Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsPhoneNumber {

private String[] alpha = new String[] {
        " ",
        "1", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
};
private StringBuilder word;

private void dfs(List<String> res, String digits, int cur) {
        if (cur >= digits.length()) {
                res.add(word.toString());
        } else {
                for (int i = 0; i < alpha[digits.charAt(cur) - '0'].length(); ++i) {
                        word.append(alpha[digits.charAt(cur) - '0'].charAt(i));
                        dfs(res, digits, cur + 1);
                        word.deleteCharAt(word.length() - 1);
                }
        }
}

public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits==null || digits.length()==0) {
                return ret;
        }
        word = new StringBuilder();
        dfs(ret, digits, 0);
        return ret;
}

//https://discuss.leetcode.com/topic/8465/my-java-solution-with-fifo-queue/2
//This is a iterative solution. For each digit added, remove and copy every
//element in the queue and add the possible letter to each element, then add
//the updated elements back into queue again. Repeat this procedure until
//all the digits are iterated.
//time complexity: Looks like 4^n. 4 cause p has 7/9 has 4 letter
//mapping - max(3,4)! You can start looking at with one letter, then two,
//and so and so forth -> calculate # of results.
public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length()==0) {
                return ans;
        }
        ans.add("");
        for(int i =0; i<digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while(ans.peek().length()==i) {
                        String t = ans.remove();
                        for(char s : mapping[x].toCharArray())
                                ans.add(t+s);
                }
        }
        return ans;
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LetterCombinationsPhoneNumber s = new LetterCombinationsPhoneNumber();
        int[] input = {1, 2, 3, 1};
        System.out.println("5,2,3,1" + s.letterCombinations("5231"));
        System.out.println("2,3" + s.letterCombinations("23"));
        System.out.println("" + s.letterCombinations(""));
}
}
