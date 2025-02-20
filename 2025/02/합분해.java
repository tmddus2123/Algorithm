import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        for(int i=0; i<=K; i++) {
            dp[i][0] = 1;
        }
        
        for (int k = 1; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[k][n] = (dp[k][n - 1] + dp[k - 1][n]) % 1000000000;
            }
        }
        System.out.print(dp[K][N]);
    }
}
