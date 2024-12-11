import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int zero = 0;
        int one = 0;
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '0') {
                zero++;
            } else if(str.charAt(i) == '1') {
                one++;           
            }
        }
        zero /= 2;
        one /= 2;

        String result = "";
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '0') {
                if(zero > 0) {
                    result += "0";
                    zero--;
                }
            } else if(str.charAt(i) == '1') {
                if(one > 0) {
                    one--;
                } else {
                    result += "1";
                }
            }
        }
        System.out.print(result);
        br.close();
    }
}
