import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<=n-k; i++) {
            max = Math.max(dp[k+i] - dp[i], max);
        }
        System.out.print(max);
        br.close();
    }
}
