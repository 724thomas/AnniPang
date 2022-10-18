public class PotentialPang extends Board{

    public static void checkPotentialRowPang(int row){
        char checkChar='O';
        char tempChar;

        for (int i=1; i<board[row].length-2; i++) {
            //O X O 일때,
            if (board[row][i - 1] == board[row][i + 1]) {
                checkChar = board[row][i - 1];
                if (row - 1 >= 0 && row+1<board.length) { //맨 윗줄이 아닐떄,
                    if (board[row + 1][i] == checkChar) { //중간에서 위에꺼랑 바꾼다
                        tempChar = board[row][i];
                        board[row][i] = board[row + 1][i];
                        board[row + 1][i] = tempChar;
                        return;
                    }
                }else if(row - 1 >= 0 && row+1<board.length) { //맨 아랫줄이 아닐때,
                    if (board[row - 1][i] == checkChar) { //중간에서 아래꺼랑 바꾼다.
                        tempChar = board[row][i];
                        board[row][i] = board[row - 1][i];
                        board[row - 1][i] = tempChar;
                        return;
                    }
                }
            }
        }
        //위 아래
        if (row>0 && row<7){
            for (int i=1; i<board[row].length-3; i++){
                if (board[row][i]==board[row][i+1]){
                    checkChar=board[row][i];
                    if (board[row-1][i-1]==checkChar){
                        tempChar=board[row-1][i-1];
                        board[row-1][i-1]=board[row][i-1];
                        board[row][i-1]=tempChar;
                        return;
                    }else if(board[row+1][i-1]==checkChar){
                        tempChar=board[row+1][i-1];
                        board[row+1][i-1]=board[row][i-1];
                        board[row][i-1]=tempChar;
                        return;
                    }else if(board[row-1][i+2]==checkChar){
                        tempChar=board[row-1][i+2];
                        board[row-1][i+2]=board[row][i+2];
                        board[row][i+2]=tempChar;
                        return;
                    }else if(board[row-1][i+2]==checkChar){
                        tempChar=board[row+1][i+2];
                        board[row+1][i+2]=board[row][i+2];
                        board[row][i+2]=tempChar;
                        return;
                    }
                }
            }
        }
        for (int i=2; i<board[row].length-4; i++){
            if (board[row][i]==board[row][i+1]){
                checkChar = board[row][i];
                if (board[row][i-2]==checkChar){
                    tempChar=board[row][i-2];
                    board[row][i-2]=board[row][i-1];
                    board[row][i-1]=tempChar;
                }else if(board[row][i+3]==checkChar){
                    tempChar=board[row][i+3];
                    board[row][i+3]=board[row][i+2];
                    board[row][i+2]=tempChar;
                }
            }
        }
    }

    public static void checkPotentialColumnPang(int column){
        char checkChar='O';
        char tempChar;

        for (int i=1; i<board.length-2; i++) {
            //O X O 일때,
            if (board[i - 1][column] == board[i + 1][column]) {
                checkChar = board[i - 1][column];
                if (column - 1 >= 0 && column + 1 < board[column].length) { //맨 윗줄이 아닐떄,
                    if (board[i][column + 1] == checkChar) { //중간에서 위에꺼랑 바꾼다
                        tempChar = board[i][column];
                        board[i][column] = board[i][column + 1];
                        board[i][column + 1] = tempChar;
                        return;
                    }
                }else if(column - 1 >= 0 && column + 1 < board[column].length) { //맨 아랫줄이 아닐때,
                    if (board[i][column - 1] == checkChar && (column + 1) < board[column].length) { //중간에서 아래꺼랑 바꾼다.
                        tempChar = board[i][column];
                        board[i][column] = board[i][column - 1];
                        board[i][column - 1] = tempChar;
                        return;
                    }
                }
            }
        }
        //위 아래
        if (column>0 && column<7){
            for (int i=1; i<board.length-3; i++){
                if (board[i][column]==board[i+1][column]){
                    checkChar=board[i][column];
                    if (board[i-1][column-1]==checkChar){
                        tempChar=board[i-1][column-1];
                        board[i-1][column-1]=board[i-1][column];
                        board[i-1][column]=tempChar;
                        return;
                    }else if(board[i-1][column+1]==checkChar){
                        tempChar=board[i-1][column+1];
                        board[i-1][column+1]=board[i-1][column];
                        board[i-1][column]=tempChar;
                        return;
                    }else if(board[i+2][column-1]==checkChar){
                        tempChar=board[i+2][column-1];
                        board[i+2][column-1]=board[i+2][column];
                        board[i+2][column]=tempChar;
                        return;
                    }else if(board[i+2][column-1]==checkChar){
                        tempChar=board[i+2][column+1];
                        board[i+2][column+1]=board[i+2][column];
                        board[i+2][column]=tempChar;
                        return;
                    }
                }
            }
        }
        for (int i=2; i<board.length-4; i++){
            if (board[i][column]==board[i+1][column]){
                checkChar = board[i][column];
                if (board[i-2][column]==checkChar){
                    tempChar=board[i-2][column];
                    board[i-2][column]=board[i-1][column];
                    board[i-1][column]=tempChar;
                }else if(board[i+3][column]==checkChar){
                    tempChar=board[i+3][column];
                    board[i+3][column]=board[i+2][column];
                    board[i+2][column]=tempChar;
                }
            }
        }
    }     
    
}
