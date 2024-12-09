/**
  객체 생성해서 정렬하는 문제를 오랜만에 풀어봐서 다 까먹었다..
*/

import java.util.*;
import java.io.*;

class Score implements Comparable<Score> {
    int num;
    int gold, silver, bronze;
    int rank;

    public Score(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = 0;
    }

    @Override
    public int compareTo(Score s) {
        if(this.gold == s.gold) {
            if(this.silver == s.silver) {
                return s.bronze - this.bronze;
             } else {
                return s.silver - this.silver;
            }
        } else {
            return s.gold - this.gold;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Score[] s =  new Score[N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            s[i] = new Score(no, gold, silver, bronze);
        }

        Arrays.sort(s);
        s[0].rank = 1;
        int endpoint = 0;
    
        for(int i=1; i<N; i++) {
            if(s[i].num == K) {
                endpoint = i;
            }
            
            if(s[i].gold == s[i-1].gold && s[i].silver == s[i-1].silver && s[i].bronze == s[i-1].bronze) {
                s[i].rank = s[i-1].rank;
            } else {
                s[i].rank = i + 1;
            }
        }
        System.out.print(s[endpoint].rank);
        br.close();
    }
}
