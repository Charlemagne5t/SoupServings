import java.util.HashMap;

public class Solution {
    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        HashMap<String, Double> memo = new HashMap<>();
        return dfs(n, n, memo);
    }

    private double dfs(int n1, int n2, HashMap<String, Double> memo) {
        if (memo.containsKey(n1 + " " + n2)) {
            return memo.get(n1 + " " + n2);
        }
        if (n1 <= 0 && n2 <= 0) {
            return 0.5;
        }
        if (n1 <= 0) {
            return 1.0;
        }
        if (n2 <= 0) {
            return 0.0;
        }

        double case100_0 = dfs(n1 - 100, n2, memo);
        double case75_25 = dfs(n1 - 75, n2 - 25, memo);
        double case50_50 = dfs(n1 - 50, n2 - 50, memo);
        double case25_75 = dfs(n1 - 25, n2 - 75, memo);

        double result = (case100_0 + case75_25 + case50_50 + case25_75) / 4;

        memo.put(n1 + " " + n2, result);

        return result;


    }
}
