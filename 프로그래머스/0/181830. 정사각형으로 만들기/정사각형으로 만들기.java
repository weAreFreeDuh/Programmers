import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        if(x==y){
            return arr;
        }else{
            int[][] newArr = new int[x>y ? x :y][x>y ? x :y];
            
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    newArr[i][j] = arr[i][j];
                }
            }
            
            return newArr;
        }
        
    }
}