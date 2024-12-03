import java.util.*;
import java.io.*;

public class Main {

    public static int[] dp;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        arr = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++) {
            LIS(i);
        }

        int max = dp[0];
    		for(int i = 1; i < n; i++) {
    			max = Math.max(max, dp[i]);
    		}
      
        System.out.println(max);
        br.close();
    }

    public static int LIS(int n) {
        if(dp[n] == 0) {
            dp[n] = 1;

            for(int i = n - 1; i >= 0; i--) {
                if(arr[i] < arr[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
