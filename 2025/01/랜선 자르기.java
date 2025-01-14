import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] line = new int[K];
        Long end = 0L;
        for(int i=0; i<K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, line[i]);
        }

        Long start = 1L;
        Long max = 0L;
        while(start <= end) {
            Long cnt = 0L;
            Long mid = (start + end) / 2L;

            for(int i=0; i<K; i++) {
                cnt += (line[i] / mid);
            }

            if(cnt >= N) {
                start = mid + 1;
                max = mid;
            } else if(cnt < N) {
                end = mid - 1;
            }
        }
        System.out.println(max);
        br.close();
    }
}
