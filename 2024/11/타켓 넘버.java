/**
  처음에 생각없이 for문으로 풀다가 다시 문제를 보니 dfs푸는 것 같아서 풀어봤다
  약간의 코드 참고를 하긴했으나 어느정도 감을 잡은거 같다?
*/
class Solution {
    public static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    public void dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
}
