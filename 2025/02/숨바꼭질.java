import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static int N, M;
    static int max = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String word = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = word.charAt(j);
            }
        }

        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M-1; j++) {
                findSquare(i, j);
            }
        }
        System.out.print(max * max);
        br.close();
    }

    public static void findSquare(int x, int y) {
        int cnt = 1;
        char standardNum = map[x][y];
        while(x + cnt < N && y + cnt < M) {
            if(standardNum == map[x + cnt][y] && standardNum == map[x][y + cnt] && standardNum == map[x + cnt][y + cnt]) {
                max = Math.max(max, (cnt + 1));
            }
            cnt++;
        }
    }
}
