import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        int end = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        int start = 1;
        Long result = 0L;
        int answer = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            result = calc(mid);
            if(result >= M) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(answer);
        br.close();
    }
    public static Long calc(int mid) {
        Long sum = 0L;
        for(int i=0; i<N; i++) {
            if(mid < arr[i]) {
                sum += (arr[i] - mid);
            }
        }
        return sum;
    }
}
