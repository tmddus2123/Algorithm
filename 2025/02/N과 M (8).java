import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        btk(0, 0, list);
        System.out.print(sb);
        br.close();
    }
    public static void btk(int start, int depth, List<Integer> list) {
        if(depth == M) {
            for(Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(list.size() > 0 && list.get(list.size() - 1) > arr[i]) {
                continue;
            }
            
            list.add(arr[i]);
            btk(i + 1, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
