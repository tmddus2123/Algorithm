import java.util.*;
import java.io.*;

public class Main {

    public static char[][] map;
    public static boolean[][] visited;
    public static int[][] dirs = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    
    public static int cnt = 0, num;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        map = new char[num][num];
        
        for(int i=0; i<num; i++) {
            String str = br.readLine();
            for(int j=0; j<num; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[num][num];
        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(visited[i][j]) {
                    continue;
                }
                bfs(i, j, false);
            }
        }
        System.out.print(cnt + " ");

        cnt = 0;
        visited = new boolean[num][num];
        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(visited[i][j]) {
                    continue;
                }
                bfs(i, j, true);
            }
        }
        System.out.print(cnt);
        
        br.close();
    }

    public static void bfs(int i, int j, boolean result) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        visited[i][j] = true;

        char color = map[i][j];
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < num && ny >= 0 && ny < num) {
                    if(visited[nx][ny]) {
                        continue;
                    }
                    if(result) {
                        if((color == 'R' || color == 'G') && map[nx][ny] == 'B') {
                            continue;
                        } else if(color == 'B' && map[nx][ny] != 'B') {
                            continue;
                        }
                    } else {
                        if(map[nx][ny] != color) {
                            continue;
                        }
                    }
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        cnt++;
    }
}
