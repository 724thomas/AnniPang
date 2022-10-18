public class PotentialPang extends Board{

    public static void checkPotentialRowPang(int row){

        for (int i=1; i<board[row].length-1; i++) {
            //O X O 일때,
            char checkChar;
            char tempChar;
            if (board[row][i - 1] == board[row][i + 1]) {
                checkChar = board[row][i - 1];
                if (row - 1 >= 0) { //맨 윗줄이 아닐떄,
                    if (board[row + 1][i] == checkChar && (row - 1) >= 0) { //중간에서 위에꺼랑 바꾼다
                        tempChar = board[row][i];
                        board[row][i] = board[row + 1][i];
                        board[row + 1][i] = tempChar;
                    }
                }
                if (row + 1 < board.length) { //맨 아랫줄이 아닐때,
                    if (board[row - 1][i] == checkChar && (row + 1) < board.length) { //중간에서 아래꺼랑 바꾼다.
                        tempChar = board[row][i];
                        board[row][i] = board[row - 1][i];
                        board[row - 1][i] = tempChar;
                    }
                }
            }
            
            //X O O X 일때, 는 필요가 없다.


        }

    }

}
