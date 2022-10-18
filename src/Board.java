import java.util.Arrays;

public class Board {

    public static char[][] board= new char[][]{
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O'}
};

    public static int scores=0;


    public static void showBoard(){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static char randomChar(){
        return (char)((Math.random()*4)+65);
    }

    public static void firstFill(){
        for (int i=0; i<board.length; i++){
            fillTopLine();
//            showBoard();
            charGoesDown();
        }
        showBoard();
    }

    public static void fillTopLine(){
        for (int i=0; i<board[0].length; i++){
            if (board[0][i]=='O'){
                board[0][i]=randomChar();
            }
        }
    }

    public static void fillAllLines(){
        for (int j=board.length-1; j>=0; j--){
            for (int i=board[j].length-1; i>=0; i--){
                if (board[j][i]=='O'){
                    board[j][i]=randomChar();
                }
            }
        }
    }

    public static void charGoesDown(){
        for (int j=board.length-2; j>=0; j--){
            for (int i=board[j].length-1; i>=0; i--){
                if (board[j+1][i]=='O'){
                    board[j+1][i]=board[j][i];
                    board[j][i]='O';
                }
            }
        }
    }


    public static void checkRowPang(int row){
        int count=1;
        int maxCount=1;
        int index=0;
        for (int i=1; i<board[row].length; i++){
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
                board[row][index-i]='O';
            }
            scores+=maxCount-2;
            showBoard();
        }
    }

    public static void checkColumnPang(int column){
        int count=1;
        int maxCount=1;
        int index=0;
        for (int i=1; i<board.length; i++){
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
                board[index-i][column]='O';
            }
            System.out.println("PANG!");
            scores+=maxCount-2;
            showBoard();
        }
    }
}
