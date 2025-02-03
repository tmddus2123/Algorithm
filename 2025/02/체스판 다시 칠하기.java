import java.util.*;
import java.io.*;

class Main {
    static char[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = word.charAt(j);
            }
        }
        int min = N * M;
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                min = Math.min(check(i, j), min);
            }
        }
        System.out.print(min);
        br.close();
    }

    public static int check(int a, int b) {
        int fix1 = 0, fix2 = 0;
        for(int i=a; i<a+8; i++) {
            for(int j=b; j<b+8; j++) {
                if(i % 2 == 0) {
                    if(j % 2 == 0) {
                        if(board[i][j] != 'W') {
                            fix1++;
                        }
                    } else {
                        if(board[i][j] != 'B') {
                            fix1++;
                        }
                    }
                } else {
                    if(j % 2 == 0) {
                        if(board[i][j] != 'B') {
                            fix1++;
                        }
                    } else {
                        if(board[i][j] != 'W') {
                            fix1++;
                        }
                    }
                }

                if(i % 2 == 0) {
                    if(j % 2 == 0) {
                        if(board[i][j] != 'B') {
                            fix2++;
                        }
                    } else {
                        if(board[i][j] != 'W') {
                            fix2++;
                        }
                    }
                } else {
                    if(j % 2 == 0) {
                        if(board[i][j] != 'W') {
                            fix2++;
                        }
                    } else {
                        if(board[i][j] != 'B') {
                            fix2++;
                        }
                    }
                }
            }
        }
        return Math.min(fix1, fix2);
    }
}
