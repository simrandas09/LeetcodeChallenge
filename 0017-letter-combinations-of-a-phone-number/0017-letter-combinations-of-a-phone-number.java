import java.util.*;

class Solution {
    private static final Map<Character, String> phoneMap = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String possibleLetters = phoneMap.get(digits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            current.append(letter);                       // choose
            backtrack(digits, index + 1, current, result); // explore
            current.deleteCharAt(current.length() - 1);    // un-choose
        }
    }
}
