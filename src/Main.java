import chapter1.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Solution solution = new Solution();
        /*System.out.println(solution.urlify("Mr John Smith    ", 17));
        System.out.println(solution.urlify("Mr John Smith    ".toCharArray(), 13));
        System.out.println(solution.isPalindromePermutation("tact coa"));
        System.out.println(solution.isPalindromePermutation("abcd"));*/
        System.out.println(solution.oneAway("pale", "ple"));
        System.out.println(solution.oneAway("pales", "pale"));
        System.out.println(solution.oneAway("pale", "bake"));
        System.out.println(solution.compression("aabbbbcccccd"));
        int[][] mat = new int[3][3];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = count++;
            }
        }
        System.out.println(Arrays.deepToString(solution.rotate90_2(mat)));

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        List<List<Integer>> matrx2 = new ArrayList<>();
        matrx2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrx2.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrx2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));


        System.out.println(matrix);
        List<List<Integer>> zeroMatrix = solution.zeroMatrix(matrix);
        System.out.println(zeroMatrix);
        List<List<Integer>> ans = solution.zeroMatrixO(matrx2);
        System.out.println(ans);
    }
}