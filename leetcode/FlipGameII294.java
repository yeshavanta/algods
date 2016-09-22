package leetcode;

/**
 * Created by ykp on 9/21/16.
 *
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".


 Note that here: in one moveZ, the player can flip two places.
 *
 */
public class FlipGameII294 {

    public static int index = 0;

    public boolean getSuccessIndex(String input){
        char[] array = input.toCharArray();
        for(int i=0;i < array.length-1;i++){
            if(array[i] == array[i+1] && array[i]=='+'){
                array[i]='-';
                array[i+1] = '-';


                boolean canWin = getSuccessIndex(new String(array));

                if(!canWin){
                    index = i;
                    return true;
                }

                array[i] = '+';
                array[i+1] = '+';
            }


        }

        return false;
    }

    public static void main(String[] args){
        FlipGameII294 flip = new FlipGameII294();
        String input = "++++";
        if(flip.getSuccessIndex(input)){
            System.out.println("yaay"+" : "+index);
        }else{
            System.out.println("Naaaa");
        }
    }
}
