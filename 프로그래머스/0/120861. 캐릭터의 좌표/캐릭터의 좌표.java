class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // board[0] == 가로 , board[0] == 세로
        int x = 0; int y= 0;
        int xlen = (board[0]-1)/2;
        int ylen = (board[1]-1)/2;
        
        for(String a : keyinput){
            if(a.equals("left") && x-1 >= -xlen)  x--;
            if(a.equals("right") && x+1 <= xlen)  x++;
            if(a.equals("down") && y-1 >= -ylen)  y--;
            if(a.equals("up") && y+1 <= ylen)  y++;
        }
        
        return new int[]{x,y};
    }
}