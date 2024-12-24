/**
  N장을 고르는 방법에 꽂혀서 dfs로 풀었는데 시간초과가 났다.
  dp로 푸는 문제라서 점화식을 세워보려고 했지만 생각이 나지 않았다...

  D[i] = P[n] + D[i-n]
  카드 n개가 들어있는 카드팩을 구매하고, 카드 i-n개를 구입한다.
*/
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] price = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
            }
        }
        System.out.print(dp[N]);
        br.close();
    }
}
