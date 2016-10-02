package leetcode;

/**
 * Created by ykp on 9/27/16.
 */
public class GameOfLife289 {

    public void displayState(int[][] matrix){
        for(int i =0;i < matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public int getLiveCount(int[][] matrix,int i, int j){
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int count = 0;
        for(int k=0;k < dx.length;k++){
            int x = i+dx[k];
            int y = j + dy[k];

            if(x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length && (matrix[x][y] & 1) == 1 ){
                ++count;
            }
        }

        return count;
    }

    public int[][] generateNextState(int[][] matrix){

        for(int i=0;i < matrix.length;i++){
            for(int j=0;  j < matrix[0].length;j++){
                int liveCount = getLiveCount(matrix,i,j);

                if(matrix[i][j] == 1){
                    if(liveCount < 2 || liveCount > 3){
                        matrix[i][j] = 1;
                    }else if(liveCount == 2 || liveCount == 3){
                        matrix[i][j] = 3;
                    }
                }else{

                    if(liveCount == 3){
                        matrix[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = matrix[i][j] >> 1;
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        GameOfLife289 game = new GameOfLife289();
        int[][] matrix = {

        };
        game.displayState(game.generateNextState(matrix));
    }
}
