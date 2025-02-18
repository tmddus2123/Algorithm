import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(i >= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + arr[i][j]);
                }

                if(j >= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + arr[i][j]);
                }

                if(i >= 1 && j >= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + arr[i][j]);
                }
            }
        }
        System.out.print(dp[N-1][M-1]);
        br.close();
    }
}
