import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int num = Integer.parseInt(br.readLine());

            int[][] rank = new int[num][2];
            for(int i=0; i<num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                rank[i][0] = Integer.parseInt(st.nextToken());
                rank[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank, (o1, o2) -> {
               return o1[0] - o2[0]; 
            });

            int cnt = 1;
            int last = rank[0][1];
            for(int i=1; i<num; i++) {
                if(rank[i][1] < last) {
                    cnt++;
                    last = rank[i][1];
                }
            }
            System.out.println(cnt);
        }
        br.close();
    }
}
