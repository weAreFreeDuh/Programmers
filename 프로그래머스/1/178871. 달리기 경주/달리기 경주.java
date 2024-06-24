import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i< players.length; i++){
            map.put(players[i],i);
        }
        
        for(int j = 0; j< callings.length; j++){
            int targetValueNum = map.get(callings[j]);
            String frontPlayer = players[targetValueNum-1];
            
            int frontPlayerNum = map.get(frontPlayer);
            map.replace(callings[j], frontPlayerNum);
            map.replace(frontPlayer, targetValueNum);
            
            players[frontPlayerNum] = callings[j];
            players[targetValueNum] = frontPlayer;
            
        }
        
        return players;
    }
}