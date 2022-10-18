import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Board {

    public static char[][] board= new char[][]{
            {'Z','X','Z','X','Z','X','Z','X','Z','X'},
            {'Y','@','@','@','@','@','@','@','@','Z'},
            {'X','@','@','@','@','@','@','@','@','X'},
            {'Z','@','@','@','@','@','@','@','@','Z'},
            {'X','@','@','@','@','@','@','@','@','X'},
            {'Z','@','@','@','@','@','@','@','@','Z'},
            {'X','@','@','@','@','@','@','@','@','X'},
            {'Z','@','@','@','@','@','@','@','@','Z'},
            {'X','@','@','@','@','@','@','@','@','X'},
            {'Z','X','Z','X','Z','X','Z','Z','X','Z'}
    };

//    public static char[][] board= new char[][]{
//            {'Z','X','Z','X','Z','X','Z','X','Z','X'},
//            {'Y','1','2','3','4','5','6','7','8','Z'},
//            {'X','9','1','2','3','4','5','6','7','X'},
//            {'Z','8','9','1','2','3','4','5','6','Z'},
//            {'X','7','8','9','1','2','3','4','5','X'},
//            {'Z','6','7','8','9','1','2','3','4','Z'},
//            {'X','5','6','7','8','9','1','2','3','X'},
//            {'Z','4','5','6','7','8','9','1','2','Z'},
//            {'X','3','4','5','6','7','8','9','1','X'},
//            {'Z','X','Z','X','Z','X','Z','Z','X','Z'}
//    };

    public static int scores=0;
    public static int charRange=5;
    public static int sleepTimeMil=100;

    public static void showBoard(String message) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        for (int i=1; i<board.length-1; i++){
            for (int j=1; j<board[0].length-1; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println(message + "Current Score : " + scores);
        try{
            Thread.sleep(sleepTimeMil);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static char randomChar(){
        return (char)((Math.random()*charRange)+65);
    }

    public static void fillAllLines(){
        for (int j=board.length-2; j>=1; j--){
            for (int i=board[j].length-2; i>=1; i--){
                if (board[j][i]=='@'){
                    board[j][i]=randomChar();
                }
            }
        }
    }

    public static void charGoesDown(){
        for (int k=1; k<board.length-2; k++){
            for (int j=board.length-2; j>=1; j--){
                for (int i=board[j].length-2; i>=1; i--){
                    if (board[j+1][i]=='@'){
                        board[j+1][i]=board[j][i];
                        board[j][i]='@';
                    }
                }
            }

        }
    }

    public static boolean checkRowPang(int row){
        int count=1;
        int maxCount=1;
        int index=0;
        for (int i=2; i<board[row].length-1; i++){
            if (board[row][i-1]==board[row][i]){
                count++;
                if (count>maxCount){
                    maxCount=count;
                    index=i;
                }
            }else{
                count=1;
            }
        }
        if (maxCount>=3){
            for(int i=0; i<maxCount; i++){
                board[row][index-i]='@';
            }
            scores+=maxCount-2;
            return true;
        }
        return false;
    }

    public static boolean checkColumnPang(int column){
        int count=1;
        int maxCount=1;
        int index=0;
        for (int i=2; i<board.length-1; i++){
            if (board[i-1][column]==board[i][column]){
                count++;
                if (count>maxCount){
                    maxCount=count;
                    index=i;
                }
            }else{
                count=1;
            }
        }
        if (maxCount>=3){
            for(int i=0; i<maxCount; i++){
                board[index-i][column]='@';
            }
            System.out.println(maxCount + "PANG!");
            scores+=maxCount-2;
            return true;
        }
        return false;
    }
}
