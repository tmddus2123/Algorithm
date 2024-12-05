import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 1];
        int[] dp = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for(int i=1; i<=num; i++) {
            dp[i] = arr[i];
            for(int j=1; j<i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }
        int max = 0;
        for(int i=1; i<=num; i++) {
            max = Math.max(dp[i], max); 
        }
        System.out.print(max);
        
        br.close();
    }
}
