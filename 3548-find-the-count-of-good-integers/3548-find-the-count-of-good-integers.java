

class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> uniqueDigitFreq = new HashSet<>();
        int half = (n + 1) / 2;

        int start = (int) Math.pow(10, half - 1);
        int end = (int) Math.pow(10, half);

        for (int i = start; i < end; i++) {
            String firstHalf = Integer.toString(i);
            String full;

            if (n % 2 == 0) {
                full = firstHalf + new StringBuilder(firstHalf).reverse().toString();
            } else {
                full = firstHalf + new StringBuilder(firstHalf.substring(0, firstHalf.length() - 1)).reverse().toString();
            }

            if (full.charAt(0) == '0') continue; // skip if it has leading zero
            long num = Long.parseLong(full);
            if (num % k == 0) {
                char[] chars = full.toCharArray();
                Arrays.sort(chars);
                uniqueDigitFreq.add(new String(chars));
            }
        }

        long result = 0;
        for (String freq : uniqueDigitFreq) {
            result += countPermutations(freq, n);
        }

        return result;
    }

    private long countPermutations(String digits, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : digits.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        return countValidPermutations(countMap, n);
    }

    private long countValidPermutations(Map<Character, Integer> countMap, int n) {
        List<Character> digits = new ArrayList<>(countMap.keySet());
        long total = 0;

        for (char firstDigit = '1'; firstDigit <= '9'; firstDigit++) {
            if (!countMap.containsKey(firstDigit)) continue;
            Map<Character, Integer> tempMap = new HashMap<>(countMap);
            tempMap.put(firstDigit, tempMap.get(firstDigit) - 1);
            if (tempMap.get(firstDigit) == 0) tempMap.remove(firstDigit);
            total += countPermutationsHelper(tempMap, n - 1);
        }

        return total;
    }

    private long countPermutationsHelper(Map<Character, Integer> freqMap, int remainingDigits) {
        long numerator = factorial(remainingDigits);
        long denominator = 1;
        for (int freq : freqMap.values()) {
            denominator *= factorial(freq);
        }
        return numerator / denominator;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
