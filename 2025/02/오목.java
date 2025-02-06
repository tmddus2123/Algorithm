import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map = new int[20][20];
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, -1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=19; i++) {
            for(int j=1; j<=19; j++) {
                if(map[i][j] == 0) {
                    continue;
                }
                
                if(case1(i, j)) { // omok
                    printAnswer(i, j);
                    return;
                }

                if(case2(i, j)) { // omok
                    printAnswer(i, j);
                    return;
                }

                if(case3(i, j)) { // omok
                    printAnswer(i, j);
                    return;
                }

                if(case4(i, j)) { // omok
                    printAnswer(i, j);
                    return;
                }
            }
        }
        System.out.print(0);
        br.close();
    }

    public static void printAnswer(int i, int j) {
        sb.append(map[i][j]).append("\n");
        sb.append(i).append(" ").append(j);
        System.out.print(sb);
    }

    public static boolean case1(int i, int j) {
        if(i > 15) {
            return false;
        }
        
        for(int k=1; k<=4; k++) {
            if(map[i][j] != map[i + k][j]) {
                return false;
            }
        }
        if(i < 15) {
            if(map[i+5][j] == map[i][j]) { // 오목아님
                return false;
            }
        }

        if(i > 1) {
            if(map[i-1][j] == map[i][j]) { // 오목아님
                return false;
            }
        }
        return true;
    }

    public static boolean case2(int i, int j) {
        if(j > 15) {
            return false;
        }

        
        for(int k=1; k<=4; k++) {
            if(map[i][j] != map[i][j + k]) {
                return false;
            }
        }
        if(j < 15) {
            if(map[i][j + 5] == map[i][j]) { // 오목아님
                return false;
            }
        }

        if(j > 1) {
            if(map[i][j-1] == map[i][j]) { // 오목아님
                return false;
            }
        }
        return true;
    }

    public static boolean case3(int i, int j) {
        if(i > 15 || j > 15) {
            return false;
        }
        
        for(int k=1; k<=4; k++) {
            if(map[i][j] != map[i + k][j + k]) {
                return false;
            }
        }
        if(i < 15 && j < 15) {
            if(map[i + 5][j + 5] == map[i][j]) { // 오목아님
                return false;
            }
        }

        if(i > 1 && j > 1) {
            if(map[i-1][j-1] == map[i][j]) { // 오목아님
                return false;
            }
        }

        return true;
    }

    public static boolean case4(int i, int j) {
        if(i < 5 || j > 15) {
            return false;
        }
        
        for(int k=1; k<=4; k++) {
            if(map[i][j] != map[i - k][j + k]) {
                return false;
            }
        }
        if(i > 5 && j < 15) {
            if(map[i - 5][j + 5] == map[i][j]) { // 오목아님
                return false;
            }
        }

        if(i < 19 && j > 1) {
            if(map[i+1][j-1] == map[i][j]) { // 오목아님
                return false;
            }
        }

        return true;
    }
}
