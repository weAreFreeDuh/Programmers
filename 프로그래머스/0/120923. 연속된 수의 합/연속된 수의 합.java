class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        
        for(int j =-1000;j<=1000; j++){
            int sum = 0;    
            for(int i =0;i<num;i++){        
                sum +=j+i;
            }
            if(sum == total){
                for(int i =0;i<num;i++){        
                    answer[i] = j+i;
                }
            }
        }
        
        
        return answer;
    }
}