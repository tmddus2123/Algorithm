import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] video = new int[N];
        int end = 0;
        int start = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            video[i] = Integer.parseInt(st.nextToken());
            end += video[i];
            start = Math.max(start, video[i]);
        }

        while(start < end) {
            int mid = (start + end) / 2;

            int cnt = getCount(mid, video, N);
            if(cnt > M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.print(start);
        br.close();
    }

    public static int getCount(int mid, int[] video, int N) {
        int cnt = 1;
        int remain = mid;
        for(int i=0; i<N; i++) {
            if(remain < video[i]) {
                cnt++;
                remain = mid;
            }
            remain -= video[i];
        }
        return cnt;
    }
}
