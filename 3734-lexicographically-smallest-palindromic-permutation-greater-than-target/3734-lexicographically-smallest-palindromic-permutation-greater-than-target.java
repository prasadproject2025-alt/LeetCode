
class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;

        // Count characters
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        // Check whether a palindrome is possible
        int odd = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                if (odd != -1) {
                    return "";
                }
                odd = i;
            }
        }

        // Characters available in the left half
        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }

        char middle = (n % 2 == 1)
                ? (char) ('a' + odd)
                : 0;

        // Try left half equal to target's left half
        int[] remaining = halfCnt.clone();
        boolean possible = true;

        for (int i = 0; i < half; i++) {
            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            remaining[c]--;
        }

        if (possible) {
            boolean allUsed = true;

            for (int x : remaining) {
                if (x != 0) {
                    allUsed = false;
                    break;
                }
            }

            if (allUsed) {
                String left = target.substring(0, half);
                String palindrome = buildPalindrome(left, middle);

                if (palindrome.compareTo(target) > 0) {
                    return palindrome;
                }
            }
        }

        // Find smallest left half > target's left half
        String left = findNextHalf(target, half, halfCnt);

        if (left == null) {
            return "";
        }

        return buildPalindrome(left, middle);
    }

    private String findNextHalf(String target, int half, int[] halfCnt) {

        // Try every possible pivot from right to left
        for (int pivot = half - 1; pivot >= 0; pivot--) {

            int[] remaining = halfCnt.clone();

            // Match target before the pivot
            boolean possible = true;

            for (int i = 0; i < pivot; i++) {
                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            // At pivot, choose smallest character
            // strictly greater than target[pivot]
            int targetChar = target.charAt(pivot) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                StringBuilder left = new StringBuilder();

                // Copy target prefix
                for (int i = 0; i < pivot; i++) {
                    left.append(target.charAt(i));
                }

                // Make this position greater
                left.append((char) ('a' + c));
                remaining[c]--;

                // Put remaining characters in sorted order
                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        left.append((char) ('a' + x));
                        remaining[x]--;
                    }
                }

                return left.toString();
            }
        }

        return null;
    }

    private String buildPalindrome(String left, char middle) {

        StringBuilder result = new StringBuilder();

        result.append(left);

        if (middle != 0) {
            result.append(middle);
        }

        // Append reverse(left)
        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}