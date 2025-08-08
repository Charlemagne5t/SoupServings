import java.util.*;

class Solution {
    public double soupServings(int n) {
        if(n >= 4800) {
            return 1.0;
        }
        Map<Long, Double> memo = new HashMap<>();
        return dfs(n, n, memo);
    }

    double dfs(int a, int b,  Map<Long, Double> memo) {

        double res1;
        double res2;
        double res3;
        double res4;
        if(memo.containsKey((long)a + b * (long) 1e9)){
            return memo.get( (long)a + b * (long) 1e9 );
        }
        if(a - 100 <= 0){
            if(b == 0){
                res1 = 0.5;
            }else res1 = 1;
        }else {
            res1 = dfs(a - 100, b, memo);
        }

        if(a - 75 <= 0) {
            if(b - 25 > 0) {
                res2 = 1;
            }else {
                res2 = 0.5;
            }
        }else if(b - 25 <= 0){
            res2 = 0;
        }else {
            res2 = dfs(a - 75, b - 25, memo);
        }

        if(a - 50 <= 0) {
            if(b - 50 > 0) {
                res3 = 1;
            }else {
                res3 = 0.5;
            }
        }else if(b - 50 <= 0){
            res3 = 0;
        }else {
            res3 = dfs(a - 50, b - 50, memo);
        }

        if(a - 25 <= 0) {
            if(b - 75 > 0) {
                res4 = 1;
            }else {
                res4 = 0.5;
            }
        }else if(b - 75 <= 0){
            res4 = 0;
        }else {
            res4 = dfs(a - 25, b - 75, memo);
        }
        memo.put((long)a + b * (long) 1e9, (res1 + res2 + res3 + res4) / 4);
        return (res1 + res2 + res3 + res4) / 4;
    }
}