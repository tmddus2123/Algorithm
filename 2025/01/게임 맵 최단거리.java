import java.util.*;

class Solution {
    public static int[][] dirs = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public static boolean[][] visited;
    public static int result = 0;
    public static int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(0, 0, maps);
        
        if(visited[n-1][m-1] == false) {
            answer = -1;
        } else {
            answer = maps[n-1][m-1];
        }
        return answer;
    }
    
    public static void bfs(int i, int j, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        maps[nx][ny] = maps[x][y] + 1;
                        cnt++;
                    }
                }
            }
        }
        if(visited[n-1][m-1]) {
            result = Math.max(result, cnt);
        }
    }
}
