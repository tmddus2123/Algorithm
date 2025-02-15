import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int size = 0;
        while(num > Math.pow(2, size)) {
            size++;
        }

        int cnt = 0;
        for(int i=size; i>=0; i--) {
            if(num - Math.pow(2, i) >= 0) {
                num -= Math.pow(2, i);
            }
            if(num == 0) {
                break;
            }
            cnt++;
        }
        System.out.print((int) Math.pow(2, size) + " " + cnt);
        br.close();
    }
}
