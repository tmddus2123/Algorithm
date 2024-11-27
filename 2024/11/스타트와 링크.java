/**
  처음에는 team1, team2 일일히 다 조합을 구해서 계산했지만
  visit으로 방문한 것과 아니것만 체크해서 방문한 것끼리 방문 안한것 끼리 계산하면 
  조금 더 수월하다
*/
import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[][] arr;

    public static boolean[] visit;
    public static int MIN = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        visit = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(MIN);
        
        br.close();
    }

    public static void dfs(int depth, int start) {
        if(depth == N/2) {
            int sum1 = 0, sum2 = 0;
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    if(visit[i] && visit[j]) {
                        sum1 += arr[i][j] + arr[j][i];
                    } else if(!visit[i] && !visit[j]) {
                        sum2 += arr[i][j] + arr[j][i];
                    }
                }
            }
            MIN = Math.min(MIN, Math.abs(sum1 - sum2));
            return;
        }

        for(int i=start; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
