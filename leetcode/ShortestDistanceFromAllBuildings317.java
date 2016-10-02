package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ykp on 9/27/16.
 */
public class ShortestDistanceFromAllBuildings317 {

    public class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int findShortestDistance(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int totalNumberOfBuildings = 0;

        int[][] distanceMap = new int[rows][cols];
        int[][] numberOfBuildingsReached = new int[rows][cols];

        int min = Integer.MAX_VALUE;

        int resultx=0, resulty=0;

        for(int i=0;i < rows;i++){
            for(int j=0;j < cols;j++){
                if(matrix[i][j] == 1){
                    doBFS(matrix,i,j,distanceMap,numberOfBuildingsReached);
                    totalNumberOfBuildings++;
                }
            }
        }

        for(int i=0;i < distanceMap.length;i++){
            for(int j=0;j < distanceMap[0].length;j++){
                if(distanceMap[i][j] != 0 && distanceMap[i][j] < min && numberOfBuildingsReached[i][j] == totalNumberOfBuildings){
                    min = distanceMap[i][j];
                    resultx = i;
                    resulty = j;
                }
            }
        }
        System.out.println("From co-ordinates: "+resultx+" : "+resulty);
        return min;
    }



    public void doBFS(int[][] matrix, int i, int j,int[][] distanceMap,int[][] numberOfBuildingsReached){
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        Queue<Point> queue = new LinkedList();


        visited[i][j] = true;
        queue.offer(new Point(i,j-1));
        queue.offer(new Point(i,j+1));
        queue.offer(new Point(i+1,j));
        queue.offer(new Point(i-1,j));
        int distance = 1;
        while(!queue.isEmpty()){

            int currentQueueSize = queue.size();

            while(currentQueueSize > 0){
                Point currentPoint = queue.poll();
                int currentRow = currentPoint.x;
                int currentCol = currentPoint.y;

                if(isSafe(matrix,visited,currentRow,currentCol)){
                    visited[currentRow][currentCol] = true;
                    distanceMap[currentRow][currentCol] += distance;
                    numberOfBuildingsReached[currentRow][currentCol] += 1;

                    queue.offer(new Point(currentRow,currentCol-1));
                    queue.offer(new Point(currentRow,currentCol+1));
                    queue.offer(new Point(currentRow+1,currentCol));
                    queue.offer(new Point(currentRow-1,currentCol));
                }

                --currentQueueSize;
            }

            distance++;

        }

    }

    public boolean isSafe(int[][] matrix, boolean[][] visited, int i, int j){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || matrix[i][j] != 0){
            return false;
        }

        return true;

    }

    public static void main(String[] args){
        ShortestDistanceFromAllBuildings317 shortest = new ShortestDistanceFromAllBuildings317();
        int[][] matrix = {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(shortest.findShortestDistance(matrix));
    }
}
