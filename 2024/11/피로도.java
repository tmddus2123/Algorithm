/**
  dfs 문제는 처음 풀어보는데 어려워서 gpt의 도움을 받았다.

  dfs 관련한 문제만 풀어봐야겠다
*/
class Solution {
    private int maxDungeons = 0;  // 최대 탐험한 던전 수를 저장하는 변수

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return maxDungeons;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        // 최대 탐험 던전 수 갱신
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않은 던전이고, 현재 피로도가 해당 던전의 최소 필요 피로도 이상인 경우
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;  // 던전을 방문 표시
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);  // 피로도 차감 후 다음 탐색
                visited[i] = false;  // 백트래킹
            }
        }
    }
}
