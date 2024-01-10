package chapter1;

import java.util.HashMap;
import java.util.List;
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

    public String compression(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1  && str.charAt(i) == str.charAt(  i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            sb.append(count);
        }
        return sb.toString();
    }

    public int[][] rotate90(int[][] mat) {
        int n = mat.length;
        if (n != mat[0].length) {
            return null;
        }

        int[][] ans = new int[n][n];
        int x = 0, y = 0;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                ans[x][y] = mat[i][j];
                y++;
            }
            y = 0;
            x++;
        }
        return ans;
    }

    public int[][] rotate90_2(int[][] mat) {
        int n = mat.length;
        for (int layer = 0; layer < n; layer++) {
            int last = n - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                int top = mat[layer][i];
                mat[layer][i] = mat[last - offset][layer];
                mat[last - offset][layer] = mat[last][last - offset];
                mat[i][last] = top;
            }
        }
        return mat;
    }

    public List<List<Integer>> zeroMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    rows[i] = 1;
                    cols[i] = 1;
                }
            }
        }
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    public List<List<Integer>> zeroMatrixO(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int colO = 1;
        // 1. make first row and col zero
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0,0);
                    matrix.get(0).set(j, 0);
                    if (j == 0) {
                        colO = 0;
                    }
                }
            }
        }
        // 2. all row or col set to zero
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        // 3. check 0th col is zero or not
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < n; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (colO == 0) {
            for (int i = 0; i < m; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }


}
