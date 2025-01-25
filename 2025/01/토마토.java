import java.util.*;
import java.io.*;

class Main {
    public static int M, N;
    public static int[][] map;
    public static int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int unripeCount = 0; // 익지 않은 토마토의 개수
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j}); // 익은 토마토 위치 저장
                } else if (map[i][j] == 0) {
                    unripeCount++; // 익지 않은 토마토 개수 증가
                }
            }
        }
        
        if (unripeCount == 0) {
            System.out.println(0); // 모든 토마토가 처음부터 익어있는 경우
            return;
        }
        
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        map[nx][ny] = 1; // 익게 만들기
                        queue.offer(new int[]{nx, ny});
                        unripeCount--;
                    }
                }
            }
        }
        System.out.println(unripeCount == 0 ? days : -1);
    }
}
