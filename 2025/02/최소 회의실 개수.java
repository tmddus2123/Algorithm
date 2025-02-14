import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] time = new int[num][2];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken()); // INteger -> Integer 수정
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 0; // 필요한 회의실 개수
        for (int i = 0; i < num; i++) {
            // 현재 회의 시작 시간 이전에 끝난 회의들을 pq에서 제거
            while (!pq.isEmpty() && pq.peek() <= time[i][0]) {
                pq.poll();
            }
            // 현재 회의 종료 시간을 pq에 추가
            pq.offer(time[i][1]);
            // 현재까지 필요한 회의실 개수 갱신
            rooms = Math.max(rooms, pq.size());
        }

        System.out.println(rooms); // 결과 출력
        br.close();
    }
}
