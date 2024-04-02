import java.util.*;
class Solution {
    // 문제를 풀기 위해선 먼저 기름의 영역의 값을 구하고
    // 그 기름의 영역을 가진 값을 합쳐 제일 큰 값을 구하는 방식으로 합니다.
    public int solution(int[][] land) {
        int answer = 0;
        int xlen = land.length;
        int ylen = land[0].length;
        
        // 방향
        int[] xdir = {1,0,-1,0};
        int[] ydir = {0,1,0,-1};
        boolean[][] v = new boolean[xlen][ylen];
        Map<Integer, Integer> map = new HashMap<>();
        int flag = 2;
        
        for(int i =0; i < xlen; i++){
            for(int j=0; j< ylen; j++){
                if(land[i][j] != 1) continue;
                int oil = 1;
                v[i][j] = true;
                land[i][j] = flag;
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i,j});
                
                while(!q.isEmpty()){
                    int[] arr = q.poll();
                    for(int d=0; d<4;d++){
                        int nx = arr[0] + xdir[d];
                        int ny = arr[1] + ydir[d];
                        
                        if(nx<0||ny<0||nx>=xlen||ny>=ylen||land[nx][ny]!=1||v[nx][ny]) continue;
                        v[nx][ny] = true;
                        land[nx][ny] = flag;
                        q.offer(new int[]{nx,ny});
                        oil++;
                    }
                }
                map.put(flag,oil);
                flag++;
            }
        }
        
        for(int i = 0; i<ylen; i++){
            Set<Integer> set = new HashSet<>();
            for(int j =0; j<xlen; j++){
                if(land[j][i] > 1) set.add(land[j][i]);
            }
            int sum = 0;
            for(int a : set){
                sum += map.get(a);
            }
            answer = Math.max(answer,sum);
        }
        
        
        return answer;
    }
}