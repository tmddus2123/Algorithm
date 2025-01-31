import java.util.*;
import java.io.*;

class Main {
    static int L, C;
    static char[] chars;
    static boolean[] visited = new boolean[26];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        
        btk(0, 0, 0, 0, "");
        System.out.print(sb);
        br.close();
    }
    public static void btk(int start, int depth, int vow, int con, String word) {
        if(depth == L) {
            if(vow >= 1 && con >= 2) {
                sb.append(word + "\n");
            }
            return;
        }
        String cur = word;
        for(int i=start; i<C; i++) {
            word += chars[i];
            
            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                btk(i + 1, depth + 1, vow + 1, con, word);
            } else {
                btk(i + 1, depth + 1, vow, con + 1, word);
            }
            word = cur;
        }
    }
}
