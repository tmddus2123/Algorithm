/**
  새로운 1차원 배열을 만들어서 풀어봤으나 메모리 초과
  시간이 굉장히 빡빡하기 때문에 
  right ~ left 배열 부분만 만들어야 한다.
*/

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1L)];
                
        int cnt = 0;
        for(long i=left; i<=right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            answer[cnt++] = Math.max(row, col) + 1;
        }
        return answer;
    }
}
