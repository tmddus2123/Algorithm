/**
  백트래킹 : 말 그대로 되추적인데, 어떤 노드의 '유망성'을 판단하여
  유망하지 않으면 부모 노드로 돌아가 다른 자식 노드를 찾는 방법.

  기본적으로 재귀를 통해 풀어야하며
  이 때 재귀를 하면서 이미 방문한 노드(값)이라면 다음 노드를 탐색하도록 하기 위해(유망한 노드인지 검사하기 위해)
  N 크기의 boolean 배열을 생성하고, 탐색과정에서 값을 담을 int 배열 arr 을 생성한다.

  dfs 함수에는 N과 M을 변수로 받아야하는 건 당연지사, depth 변수를 추가해야한다.
  depth를 통해 재귀가 깊어질 때마다 depth를 1씩 증가시켜 M과 같아지면
  더이상 재귀를 호출하지 않고 탐색과정 중 값을 담았던 arr 배열을 출력해주고 return 하는 역할을 위해서다.
  https://st-lab.tistory.com/114
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visit;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        btk(n, m, 0);

        br.close();
    }

    public static void btk(int n, int m, int depth) {
        if (depth == m) { // 탐색이 끝나고 arr 배열 출력
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) { // 방문하지 않은 노드
                visit[i] = true;
                arr[depth] = i + 1;
                btk(n, m, depth + 1); // 탐색
                visit[i] = false; // 복구
            }
        }
    }
}
