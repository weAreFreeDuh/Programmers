class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        
        for(String d : dic){
            String[] tmp = d.split("");    
            int[] count = new int[spell.length];
            for(int i =0; i<tmp.length; i++){   
                
                for(int j =0; j<spell.length; j++){
                    if(tmp[i].equals(spell[j])) {
                        count[j] = 1;   
                    }
                }
            }
             int sum = 0;
                for(int a : count){
                    sum = sum + a;
                }
                System.out.println(sum);
                if(sum == spell.length) answer = 1;
        }
        return answer;
    }
}