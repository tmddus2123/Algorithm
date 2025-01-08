/**
  BFS 공부중!!!
*/

import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map;
    public static boolean[][] visited;
    public static int n, m, cnt = 0, max = 0;
    
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.print(cnt + "\n" + max);
        br.close();
    }

    public static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;

        int sum = 1;

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int x = now[0];
            int y = now[1];


            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < n && nx >= 0 && ny < m && ny >= 0) {
                    if(!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        sum++;
                    }
                }
            }
        }
        if(sum >= 1) {
            cnt++;
            max = Math.max(max, sum);
        }
    }
}
