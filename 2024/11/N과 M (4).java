/**
  우선 출력을 System.out.print로 계속했더니 시간 초과 오류가 떠서 StringBuilder로 바꿨다
  
  어떤 문제에서 백트래킹을 써야하는지 감이 잡히는 것 같지만 실제로 응용해서 문제로 나오면
  아직은 어려울 것 같다.
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        btk(n, m, 0, 0);
        System.out.print(sb);

        br.close();
    }

    public static void btk(int n, int m, int depth, int prev) {

        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (prev == i + 1) {
                visit[i] = false;
            }

            if (!visit[i] && prev <= i + 1) {
                visit[i] = true;
                arr[depth] = i + 1;
                btk(n, m, depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
