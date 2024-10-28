/**
  점화식 jump(n) = jump(n-2) + jump(n-1);
*/
class Solution {
    public static int[] dp = new int[2001];
    
    public long solution(int n) {
        long answer = 0;
        
        dp[1] = 1;
        dp[2] = 2;
        
        answer = jump(n);
        return answer;
    }
    public int jump(int n) {
        if(dp[n] == 0) {
            dp[n] = (jump(n-2) + jump(n-1)) % 1234567;
        }
        return dp[n];
    }
}
