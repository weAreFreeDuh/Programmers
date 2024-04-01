import java.util.*;
class Solution {
    // 처음 위치에 대한 값을 가져오는 것.
    // 움직일 경우 1씩 감소 시키면서 움직일 것.
    // E 오른쪽, W 왼쪽, N 위쪽, S 아래쪽
    // 장애물에 닿을 시 명령 자체는 생략하는 방식으로 해결
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int len = park.length;
        int ylen = park[0].length();
        int[][] Zone = new int[len][ylen];
        int x = 0;
        int y = 0;
        
        for(int i =0; i<len; i++){
            String[] tmp = park[i].split(""); 
            
            for(int j = 0; j<tmp.length; j++){
                //System.out.println(tmp[j]);
                if(tmp[j].equals("S")){
                    x = i;  
                    y = j;  
                }
                if(tmp[j].equals("X")){
                    Zone[i][j] = 1;
                }
            }
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int z=0; z < routes.length; z++){
            String[] command = routes[z].split(" ");
            
            String dir = command[0];
            int go = Integer.parseInt(command[1]);
            int ax = 0;
            int ay = 0;
            int bx = x;
            int by = y;
            
            while(go > 0){
                if(dir.equals("E")){
                    ax = bx; ay = by+1;
                }
                if(dir.equals("W")){
                    ax = bx; ay = by-1;
                }
                if(dir.equals("S")){
                    ax = bx+1; ay = by;
                }
                if(dir.equals("N")){
                    ax = bx-1; ay = by;
                }
                if(ax<0 || ay<0 || ax>=len || ay>=ylen || Zone[ax][ay] == 1 ){
                    // System.out.println(Zone[ax][ay]);
                    // System.out.println(ylen);
                    //System.out.println(ax+" "+ay);
                    // ax = bx; ay = by;
                    bx = x; by =y;
                    break;
                }
                bx = ax;
                by = ay;
                //System.out.println(bx+" "+by);
                go--;
            }
            x = bx;
            y = by;
            System.out.println(x+" "+y);
        }
        
        return new int[]{x,y};
    }
    
    
}