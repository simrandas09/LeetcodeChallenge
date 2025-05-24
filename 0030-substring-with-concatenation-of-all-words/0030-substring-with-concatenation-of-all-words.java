import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;

        // Create a frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        // Sliding window: check each possible offset to align with word boundaries
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            Map<String, Integer> windowWords = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(word)) {
                    windowWords.put(word, windowWords.getOrDefault(word, 0) + 1);

                    // If word occurs too many times, slide window from the left
                    while (windowWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowWords.put(leftWord, windowWords.get(leftWord) - 1);
                        left += wordLength;
                    }

                    // If the window contains all words exactly once
                    if (right - left == totalLength) {
                        result.add(left);
                    }
                } else {
                    // Reset window if word not in words list
                    windowWords.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}
