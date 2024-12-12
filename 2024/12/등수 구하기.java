/**
  어제 못풀어서 넘어간 문제였는데
  차근차근 구현해서 풀었다. ;)
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        int top = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        if(top == 0) {
            System.out.print(1);
            return;
        }

        int[] arr = new int[top];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<top; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for(int i=0; i<top; i++) {
            if(arr[i] >= score) {
                rank++;
                if(i == limit-1) {
                    rank = -1;
                } else if(arr[i] == score) {
                    rank--;
                }
            } else {
                break;
            }
        }
        System.out.print(rank);
        br.close();
    }
}
