import chapter1.Solution;

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
    }
}