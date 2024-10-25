/**
  문제가 좀 어려워보이지만 막상 풀이는 쉽다
  2로 나눠서 나머지가 있으면 에너지 +1를 해주면 된다.

  문제만 보고 유추해내기가 어렵다
*/
public class Solution {
    public int solution(int n) {
        int ans = 1;

        while(n > 1) {
            if(n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }
        return ans;
    }
}
