/**
  6개월 전엔 이게 무슨 문제냐고 냅다 완전 탐색으로 풀어보려고 했던 문제였다.
  점화식을 찾으니 아주 쉽게 풀린다.

  하지만 처음에는 재귀함수로 구현해서 풀었더니 생각보다 시간이 많이 나와서
  반복문으로 풀어보니 시간이 적게 나왔다.

  메모제이션으로 중복계산을 줄이긴 하지만 함수 호출 자체의 비용이 있고
  반복문의 경우는 함수 호출 없이 바로 계산을 진행하기때문에 호출 스택에 의한 오버헤드가 없다.
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            int[][] dp = new int[num + 1][2];
            int[][] arr = new int[num + 1][2];

            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=num; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            for(int i=2; i<=num; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
            }
            bw.write(Math.max(dp[num][0], dp[num][1]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
