import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 맥주 선택
        int M = Integer.parseInt(st.nextToken()); // 선호도
        int K = Integer.parseInt(st.nextToken()); // 맥주갯수

        int[][] beer = new int[K][2];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            beer[i][0] = Integer.parseInt(st.nextToken()); // 선호도
            beer[i][1] = Integer.parseInt(st.nextToken()); // 레벨
        }
        Arrays.sort(beer, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int i=0; i<K; i++) {
            pq.offer(beer[i][0]);
            sum += beer[i][0];

            if(pq.size() > N) {
                sum -= pq.poll();
            }

            if(pq.size() == N && sum >= M) {
                System.out.print(beer[i][1]);
                return;
            }
        }
        System.out.print(-1);
        br.close();
    }
}
