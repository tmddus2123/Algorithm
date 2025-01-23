import java.util.*;
import java.io.*;

class Main {

    public static int F, G, U, D;
    public static int[] checked;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        checked = new int[F + 1];
        visited = new boolean[F + 1];

        bfs(S);
        if (visited[G]) {
            System.out.println(checked[G]);
        } else {
            System.out.println("use the stairs");
        }

        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            // 위로 이동
            int up = now + U;
            if (up <= F && !visited[up]) {
                visited[up] = true;
                checked[up] = checked[now] + 1;
                q.offer(up);
            }

            // 아래로 이동
            int down = now - D;
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                checked[down] = checked[now] + 1;
                q.offer(down);
            }
        }
    }
}
