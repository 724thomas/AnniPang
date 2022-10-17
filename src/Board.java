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
        return (char)((Math.random()*6)+65);
    }

    public static void firstFill(){
        for (int i=0; i<board.length; i++){
            fillTopLine();
            showBoard();
            charGoesDown();
            showBoard();
        }
    }

    public static void fillTopLine(){
        for (int i=0; i<board[0].length; i++){
            if (board[0][i]=='O'){
                board[0][i]=randomChar();
            }
        }
    }

    public static void charGoesDown(){
        for (int j=0; j<board.length-1; j++){
            for (int i=0; i<board[0].length; i++){
                if (board[j+1][i]=='O'){
                    board[j+1][i]=board[j][i];
                    board[j][i]='O';
                }
            }
        }
    }

    public static void checkRowPang(int row){
        Loop1:
        for (int i=0; i<board.length-2; i++){
            if (board[row][i]==board[row][i+1]){
                if (board[row][i]==board[row][i+2]){
                    board[row][i]='O'; board[row][i+1]='O'; board[row][i+2]='O';
                    System.out.println("1점!");
                    showBoard();
                    break Loop1;
                }
            }
        }
    }

    public static void checkRow(int row){
        int count=1;
        int maxCount=1;
        int index=0;
        char prev = board[row][0];
        for (int i=1; i<board[row].length; i++){
            if (board[row][i]==prev){
                count+=1;
                if (maxCount<count){
                    maxCount=count;
                    index=i;
                }
            }else{
                count=1;
                prev=board[row][i];
            }
        }
        if (maxCount>=3){
            for (int i=index-maxCount; i<index;i++){
                board[row][i+1]='O';
                System.out.println(index-maxCount);
            }
            System.out.println(maxCount-2);
            showBoard();
        }
    }
}
