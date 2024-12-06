/**
  계속 알고리즘 문제만 풀다가 갑자기 구현 문제 푸니까 머리가 잘 안돌아간다..
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        int f = (H-1)/(N+1)+1; 
		    int s = (W-1)/(M+1)+1;
            
        System.out.print(f*s);

        br.close();
    }
}
