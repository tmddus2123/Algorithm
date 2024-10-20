/**
  문제에서 1234567 로 나눈 나머지를 리턴하라해섯 이해를 잘 못했다.
  재귀함수로 풀어버리니까 바로 시간초과. . .
*/
// 첫번째 풀이
class Solution {
  public int solution(int n) {
    int answer = recur(n-1);

    return answer;
  }
  public recur(int num) {
    if(num <= 2) return num;

    return recur(num-1) + recur(num-2); 
  }
}

// 두번째 풀이
class Solution {
    public int solution(long n) {
        int answer = 0;
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        for(int i=1; i<n; i++){
             f2 = (f0 + f1) % 1234567;
            f0 = f1;
            f1 = f2;
        }
        answer = f2;
        return (int) answer;
    }
}
