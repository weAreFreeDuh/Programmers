class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int diff = common[1] - common[0];
        int diff2 = common[2] - common[1];
        
        if(diff == 0){
            answer = common[common.length-1];
        }else if(diff== diff2){
            answer = common[common.length-1] + diff;
        }else{
            answer = common[common.length-1] * (diff2/diff);
        }
        
        return answer;
    }
}