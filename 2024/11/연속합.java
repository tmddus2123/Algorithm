/**
  처음엔 dp 에 순서대로 누적합을 넣고
  2중 for문으로 차례대로 계산하는 방법으로 했지만 시간 초과가 떴다.

  질문을 보니 반복문 하나로 해결할 수 있다고해서 찾아보니
  dp 배열에 그냥 누적합을 넣는게 아니고 누적합과 현재 값을 비교해서 가장 최대값을 넣어주는 것이다.
*/
import java.util.*;
import java.io.*;

public class Main {

    public static int[] dp;
    public static int[] arr;
    public static int MAX = -1000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        dp = new int[num + 1];
        arr = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=num; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            MAX = Math.max(dp[i], MAX);
        }
        System.out.println(MAX);
        
        br.close();
    }
}
