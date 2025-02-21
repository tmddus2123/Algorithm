import java.util.*;
import java.io.*;

class Main {
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        System.out.println(A(N, P, Q));
        br.close();
    }

    
    public static long A(long n, long P, long Q) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n); 

        long result = A(n / P, P, Q) + A(n / Q, P, Q);
        memo.put(n, result);
        return result;
    }
}
