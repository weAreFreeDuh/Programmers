class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length,wallpaper[0].length(),0,0};
        
        // i는 x값, j는 y값
        for(int i = 0; i<wallpaper.length; i++){
            for(int j = 0; j<wallpaper[i].length(); j++){
                // System.out.println(wallpaper[i].charAt(j));
                if(wallpaper[i].charAt(j) == '#') {
                    if(answer[0] > i) answer[0] = i;
                    if(answer[1] > j) answer[1] = j;
                    if(answer[2] < i+1) answer[2] = i+1;
                    if(answer[3] < j+1) answer[3] = j+1;
                }
                
            }
        }
        
        
        return answer;
    }
}