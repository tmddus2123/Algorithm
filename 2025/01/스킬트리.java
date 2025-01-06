class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
            int[] trees = new int[skill_trees[i].length()];
            
            for(int j=0; j<skill_trees[i].length(); j++) {
                int index = skill.indexOf(skill_trees[i].charAt(j));
                if(index >= 0) {
                    trees[j] = index + 1;
                }
            }
            
            int order = 1;
            boolean result = true;
            for(int j=0; j<trees.length; j++) {
                if(trees[j] == 0) {
                    continue;
                } else if(trees[j] != order) {
                    result = false;
                    break;
                } else {
                    order++;
                }
            }
            if(result) {
                answer++;
            }
        }
        return answer;
    }
}
