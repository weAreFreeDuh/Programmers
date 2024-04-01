import java.util.*;
class Solution {
    /*
    신고당한 인원은 한명 당 한번밖에 할 수 없음.
    k 번 이상 신고된 유저는 정지, 신고한 유저들에게 메일 발송.
    각 유저가 받은 메일 결과 수를 return
    
    문제를 풀기 위해 한 생각.
    신고를 결국 하는 거에 있어서 신고자의 정보와 신고당한 자의 정보가 필수
    
    회원마다 신고당한 횟수를 담는 배열이 필요하고
    신고 당한 횟수가 k보다 높다면 신고자의 정보를 담은 배열에 맞춰야한다.
    
    */
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] reported = new int[len];
        int[][] history = new int[len][len];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<len; i++){
            map.put(id_list[i],i);
        }    
        
        for(String tmp : report){
            //System.out.println(tmp);
            String[] str = tmp.split(" ");
            
            //System.out.println(history[map.getOrDefault(str[0],0)][map.getOrDefault(str[1],0)]);
            if(history[map.getOrDefault(str[0],0)][map.getOrDefault(str[1],0)] < 1){
                // 신고 당한 사람의 횟수
                reported[map.getOrDefault(str[1],0)] += 1;
            }
            history[map.getOrDefault(str[0],0)][map.getOrDefault(str[1],0)] +=  1;
            
        }
        
        //System.out.println(Arrays.toString(reported));
        
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){ // 신고자
            for(int j =0; j < len; j++){ // 신고 당한자
                if(i == j) continue;
                if(reported[j] >= k && history[i][j] >= 1 ){
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}