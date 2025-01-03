import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] map = new int[num][num];
        Long[][] dp = new Long[num][num];
        
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<num; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0L;
            }
        }

        dp[0][0] = 1L;
        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(map[i][j] == 0) {
                    break;
                }
                
                if(i + map[i][j] < num) {
                    dp[i + map[i][j]][j] += dp[i][j];
                }

                if(j + map[i][j] < num) {
                    dp[i][j + map[i][j]] += dp[i][j];
                }
            }
        }
        System.out.print(dp[num-1][num-1]);
    }
}
