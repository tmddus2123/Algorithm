import java.util.*;
import java.io.*;

public class Main {

    public static int[] standard;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        standard = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            title[i] = st.nextToken();
            standard[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
            int power = Integer.parseInt(br.readLine()); 
            int index = search(power);
            bw.write(title[index] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int search(int power) {
        int start = 0;
        int end = standard.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(power <= standard[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
