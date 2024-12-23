/**
  점화식을 찾으면 간단하게 풀 수 있는 문제이다.
*/
import java.util.*;
import java.io.*;

public class Main {

    public static Integer[][] dp = new Integer[30][30];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i=0; i<30; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
            dp[i][i] = 1;
        }
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dfs(N, M);
            bw.write(dp[N][M] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static Integer dfs(int N, int M) {
        if(N <= 1 || M == N) {
            return dp[N][M];
        }
        
        if(dp[N][M] == null) {
            dp[N][M] = dfs(N-1, M-1) + dfs(N, M-1);
        }

        return dp[N][M];
    }
}
