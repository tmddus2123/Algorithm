/**
  간단한 피보나치 비슷한 dp를 풀땐 할만하다고 느꼈는데
  살짝 응용되니까 이해하기 어려웠다...
*/
import java.io.*;

public class Main {
    public static int[] dp;
    public static int[] score;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        dp = new int[num];
        score = new int[num];
        
        for(int i=0; i<num; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recur(num - 1));
        br.close();
    }

    public static int recur(int n) {
        if(n == 0) return score[0];
        if(n == 1) return score[0] + score[1];
        if(n == 2) return Math.max(score[0] + score[2], score[1] + score[2]);
        
        if(dp[n] == 0) {
            dp[n] = Math.max(recur(n-2) + score[n], recur(n-3) + score[n-1] + score[n]);
        }
        return dp[n];
    }
    
}
