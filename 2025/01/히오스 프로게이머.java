/**
  뒤돌면 자꾸 잊어버려서 속상하다..
  완벽하게 이해할 수 있을만큼 공부하자
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] level = new int[N];
        int start = Integer.MAX_VALUE;
        
        for(int i=0; i<N; i++) {
            level[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, level[i]);
        }

        int end = 100000001;
        int result = start;
        while(start <= end) {
            int mid = (start + end) / 2;
            Long sum = 0L;
            for(int i=0; i<N; i++) {
                if(level[i] < mid) {
                    sum += mid - level[i];
                }
            }
            if(sum <= K) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
        br.close();
    }
}
