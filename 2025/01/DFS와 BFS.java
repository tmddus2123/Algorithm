import java.util.*;
import java.io.*;

public class Main {

    public static boolean[] visited;
    public static int[][] arr;

    public static int N = 0;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);
        
        System.out.print(sb);
        br.close();
    }
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for(int i=1; i<=N; i++) {
            if(!visited[i] && arr[start][i] == 1) {
                dfs(i);
            }
        }
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            for(int i=1; i<=N; i++) {
                if(!visited[i] && arr[start][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
