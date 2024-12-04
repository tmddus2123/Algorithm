import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean plus = true;
        int sum = 0;
        int calc = 0;
        String num = "";
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                if(plus) {
                    sum += Integer.parseInt(num);
                } else {
                    sum -= Integer.parseInt(num);
                }
                if(str.charAt(i) == '-') {
                    plus = false;
                }
                num = "";
            } else {
                num += str.charAt(i);
            }
        }
        if(plus) {
            sum += Integer.parseInt(num);
        } else {
            sum -= Integer.parseInt(num);
        }
        System.out.print(sum);
        br.close();
    }
}
