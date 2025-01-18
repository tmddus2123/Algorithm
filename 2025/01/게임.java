/**
  재밌는 문제이다
  승률 구하는 부분에 오차가 생겨 * 100을 미리 해준다고 한다.
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());
        double Z = Math.floor(Y * 100 / X);

        if(Z >= 99) {
            System.out.print(-1);
            return;
        }
        
        int start = 1;
        int end = 1000000000;
        while(start < end) {
            int mid = (start + end) / 2;
            int rate = (int)((Y + mid) * 100 / (X + mid));
            
            if(rate > Z) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        br.close();
    }
}
