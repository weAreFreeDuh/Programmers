// A와 B 중 선물을 많이 한 사람은 선물을 받는다.
// A와 B가 선물을 받은 기록이 없거나, 주고 받은 수가 같다면 선물 지수가 더 큰 사람이 선물을 받는다.
// 선물 지수는 이번달 까지 자신이 친구들에게 준 선물의 수에서 받은 수를 뺀 값
// 선물 지수도 같다면 다음 달에 선물을 주고 받지 않는다.
// 다음 달을 예측하는 코드

// 결과 값은 다음달에 가장 많은 선물을 받은 친구의 선물 수
// gifts 는 A 가 선물 준 친구의 이름, B는 선물 받은 친구의 이름

// 리스트 해쉬 값을 활용하여 선물 한 사람과 선물 받은 사람의 개수를 저장.
// 선물을 한 사람 끼리 비교를 하여 선물을 준다.
// 선물하여 주고 받은 수가 같다면 선물 지수가 더 큰 사람에게 선물 선물지수도 같다면 무효
// 선물 기록이 없다면, 선물 지수 비교.
import java.util.*;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 선물 지수 구하기
        Map<String, Integer> gifting = new HashMap<>();
        Map<String, Integer> gifted = new HashMap<>();
        Map<String, Integer> giftscore = new HashMap<>();
        
        for(int i=0; i<gifts.length; i++){
            String[] tmp = gifts[i].split(" ");
            int giftingCount = gifting.getOrDefault(tmp[0],0) + 1;
            int giftedCount = gifted.getOrDefault(tmp[1],0) + 1;
            
            gifting.put(tmp[0],giftingCount);
            gifted.put(tmp[1],giftedCount);
            
        }
        
        for (Map.Entry<String, Integer> entry : gifting.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            giftscore.put(key, value - gifted.getOrDefault(key, 0));
            //System.out.println(key + " : " + value);
            //System.out.println(key + " : " + gifted.getOrDefault(key,0));
            //System.out.println(key + " : " + giftscore.getOrDefault(key,0));
        }
        
        Map<String, Integer> score = new HashMap<>();
        for(int x = 0; x< friends.length; x++){
            for(int y=0; y< friends.length; y++){
                if(x==y) continue;
                if(func(friends[x],friends[y],gifts) > func(friends[y],friends[x],gifts) 
                   ){
                    int num = score.getOrDefault(friends[x],0) + 1;
                    score.put(friends[x],num);
                }else if(func(friends[x],friends[y],gifts) == func(friends[y],friends[x],gifts)
                    && giftscore.getOrDefault(friends[x],0) > giftscore.getOrDefault(friends[y],0)){
                    int num = score.getOrDefault(friends[x],0) + 1;
                    score.put(friends[x],num);
                }
                
            }
        }
        
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if(answer < entry.getValue()){
                answer = entry.getValue();
            }
        }
        
        return answer;

    }
    
    public int func(String giftingName, String giftedName,String[] gifts){
        int num = 0;
        for(int i = 0; i <gifts.length; i++){
            String[] tmp = gifts[i].split(" ");
            if(tmp[0].equals(giftingName) && tmp[1].equals(giftedName)){
                num++;
            }
            
        }
        return num;
    }
}