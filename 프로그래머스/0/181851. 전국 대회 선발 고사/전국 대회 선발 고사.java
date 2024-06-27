import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int len = rank.length;
        
        for(int i = 0; i < len; i++){
            if(!attendance[i]) rank[i] = 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int j=0; j < len; j++){
            if(rank[j] != 0) map.put(rank[j],j);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        int a = map.getOrDefault(keySet.get(0),0);
        int b = map.getOrDefault(keySet.get(1),0);
        int c = map.getOrDefault(keySet.get(2),0);
        
        return (10000*a) + (100*b) + c;
    }
}