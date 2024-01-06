package chapter1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isUnique(String str) {
        /*
            TC = O (n Log (n))
            SC = O(1)
         */
        int len = str.length();
        for (int i = 0; i < len; i++ ) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkPermutation(String a, String b) {
        /*
        TC O(N) + O(N) + O(N) = 3O(N) = O(N)
        SC O(26) = 0(1)
         */
        if (a.length() != b.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }

    public String urlify(String str, int N) {
        StringBuilder sb = new StringBuilder();
        for (char c: str.trim().toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public char[] urlify(char[] str, int N) {
        int i = str.length - 1;
        N = N -  1;
        while (N >= 0 && i >= 0) {
            if (str[N] == ' ') {
                str[i--] = '0';
                str[i--] = '2';
                str[i--] = '%';
            } else {
                str[i--] = str[N];
            }
            N--;
        }
        return str;
    }

    public boolean isPalindromePermutation(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                map.put(c , map.getOrDefault(c, 0) + 1);
            }
        }
        int oneChar = 0;
        for (int value : map.values()) {
            if (value % 2 != 0) {
                oneChar++;
            }
            if (oneChar > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean oneAway(String a, String b) {
        int[] freq = new int[26];
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
        }
        int sum = 0;
        for(int i : freq) {
            sum += Math.abs(i);
        }
        return sum <= 1;
    }
}
