import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 부분 수열 탐색 시작
        dfs(0, 0, s);

        // 공집합 제외
        if (s == 0) {
            answer--;
        }

        System.out.print(answer);

        br.close();
    }

    public static void dfs(int depth, int sum, int s) {
        // 모든 요소를 다 확인한 경우
        if (depth == arr.length) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        // 현재 요소를 포함하지 않는 경우
        dfs(depth + 1, sum, s);

        // 현재 요소를 포함하는 경우
        dfs(depth + 1, sum + arr[depth], s);
    }
}
