import java.util.*;
import java.io.*;

class Main {

    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> chickenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) { // 치킨집
                    chickenList.add(new int[]{i, j});
                }
            }
        }
        btk(0, new ArrayList<>());
        System.out.print(min);
        br.close();
    }

    public static void btk(int depth, List<int[]> selected) {
        // M개의 치킨집을 선택했을 때 최소 거리 계산
        if (selected.size() == M) {
            min = Math.min(min, calcMin(selected));
            return;
        }

        // 치킨집을 선택하면서 탐색
        for (int i = depth; i < chickenList.size(); i++) {
            selected.add(chickenList.get(i));  // 현재 치킨집 선택
            btk(i + 1, selected);  // 다음 치킨집 선택
            selected.remove(selected.size() - 1);  // 백트래킹
        }
    }

    public static int calcMin(List<int[]> selected) {
        int sum = 0;
    
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 1) {
                    continue;
                }

                int m = Integer.MAX_VALUE;
                for(int[] select : selected) {
                    m = Math.min(m, Math.abs(i - select[0]) + Math.abs(j - select[1]));
                }
                sum += m;
            }
        }
        return sum;
    }
}
