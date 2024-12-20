/**
  0과 1이 몇번 나왔는지 갯수를 체크해야하는 문제인데
  물론 하나하나 계산하면 시간초과로 통과하지 못한다.

  dp[n][0] = dp[n-1][0] + dp[n-2][1];
  dp[n][1] = dp[n-1][1] + dp[n-2][1];
  점화식은 세웠지만 막상 구현을 어떻게 해야할지 모르겠어서 찾아봤다ㅠ

  함수를 저런식으로도 구현할 수 있구나.. 너무 지식이 국한된 것 같아서 슬프다.
*/
import java.util.*;
import java.io.*;

public class Main {

    public static Integer[][] dp = new Integer[41][2];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        for(int t=0; t<testCase; t++) {
            int num = Integer.parseInt(br.readLine());
            fibo(num);
            bw.write(dp[num][0] +  " " + dp[num][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static Integer[] fibo(int num) {
        if(dp[num][0] == null || dp[num][1] == null) {
            dp[num][0] = fibo(num-1)[0] + fibo(num-2)[0];
            dp[num][1] = fibo(num-1)[1] + fibo(num-2)[1];
        }
        return dp[num];
    }
}
