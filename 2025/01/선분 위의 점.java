import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dots = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }

        // 점 배열 정렬
        Arrays.sort(dots);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            // lowerBound 구현
            int low = 0, high = N;
            while (low < high) {
                int mid = (low + high) / 2;
                if (dots[mid] < x1) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int left = low;

            // upperBound 구현
            low = 0;
            high = N;
            while (low < high) {
                int mid = (low + high) / 2;
                if (dots[mid] <= x2) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int right = low;

            // 결과 계산
            sb.append((right - left) + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}
