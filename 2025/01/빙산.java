import java.util.*;
import java.io.*;

class Main {
    public static int N, M;
    public static int[][] map, meltMap;
    public static boolean[][] visited;
    public static int[][] dirs = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) { // 빙산 높이 정보 배열
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) { // 1년씩 탐색
            visited = new boolean[N][M]; // 1년 마다 초기화
            meltMap = new int[N][M]; // 1년 마다 바뀌는 지도를 저장
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!visited[i][j] && map[i][j] != 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            if(cnt == 0 || cnt >= 2) { // 빙하가 없거나 두 덩어리 이상 나눠진 경우
                if(cnt == 0) {
                    year = 0;
                }
                break;
            }
            map = meltMap; // 바뀐 지도로 갱신
            year++; // 1년 후
        }
        System.out.println(year);
        br.close();
    }
    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            int melt = 0;
            for(int[] dir : dirs) { // 4방향 탐색
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(!visited[nx][ny]) {
                        if(map[nx][ny] == 0) { // 0(바다)인 경우 녹는다.
                            melt++;
                        } else { // 빙하라면 탐색을 진행해야하니 큐에 넣어준다.
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true; // 방문 처리
                        }
                    }
                }
            }
            int ice = 0;
            if(map[x][y] - melt > 0) {
                ice = map[x][y] - melt;
            }
            meltMap[x][y] = ice; // 1년이 지난 새로운 지도
        }
    }
}
