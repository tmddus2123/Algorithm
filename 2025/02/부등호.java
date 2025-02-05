import java.util.*;
import java.io.*;

class Main {

    static String[] sign;
    static boolean[] visited = new boolean[10];
    static int K;
    static long max = 0L, min = 9876543210L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        sign = new String[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sign[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(0, i, new StringBuilder().append(i));
            visited[i] = false;
        }

        System.out.println(max);
        System.out.println((min / Math.pow(10, K) < 1) ? "0" + min : min);
        br.close();
    }

    public static void dfs(int depth, int num, StringBuilder sb) {
        if (depth == K) {
            long n = Long.parseLong(sb.toString());
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        if (sign[depth].equals("<")) {
            for (int j = num + 1; j < 10; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    sb.append(j);
                    dfs(depth + 1, j, sb);
                    visited[j] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        } else {
            for (int j = num - 1; j >= 0; j--) {
                if (!visited[j]) {
                    visited[j] = true;
                    sb.append(j);
                    dfs(depth + 1, j, sb);
                    visited[j] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
