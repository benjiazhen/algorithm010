class Solution {
 public int robotSim(int[] commands, int[][] obstacles) {
        return method1(commands,obstacles);
    }

    /**
     * 关键：方向，某个方向上的单位增量
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     */
    private int method1(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0;
        int y = 0;
        int direction = 0;
        //单位增量
        int[][] delt = {{0,1},{1,0},{0,-1},{-1,0}};
        //障碍缓存
        Set<String> obstacleCache = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleCache.add(obstacle[0]+","+obstacle[1]);
        }
        for (int command : commands) {
            if(command >= 0)
            {
                for(int step = 0;step < command ; step ++)
                {
                    x +=  delt[direction][0];
                    y +=  delt[direction][1];
                    if(obstacleCache.contains(x+","+y))
                    {
                        x -=  delt[direction][0];
                        y -=  delt[direction][1];
                        break;
                    }
                    result = Math.max(result,x*x+y*y);
                }
            }else{
                direction = command == -1 ? (direction+1)%4 : (direction+3)%4;
            }
        }
        return result;
    }
}