public class PotentialPang extends Board{

    public static void swap(int row, int column, String direction){
        char tempChar=board[row][column];
        switch (direction){
            case "UP":
                board[row][column]=board[row-1][column];
                board[row-1][column]=tempChar;
                break;
            case "DOWN":
                board[row][column]=board[row+1][column];
                board[row+1][column]=tempChar;
                break;
            case "LEFT":
                board[row][column]=board[row][column-1];
                board[row][column-1]=tempChar;
                break;
            case "RIGHT":
                board[row][column]=board[row][column+1];
                board[row][column+1]=tempChar;
                break;
        }
    }
    public static boolean checkPotentialRowPang(int row){
        char checkChar='O';
        char tempChar;
        // O X O
        for (int i=2; i<board[row].length-2; i++){
            if (board[row][i-1]==board[row][i+1]){
                checkChar=board[row][i-1];
                if (board[row+1][i]==checkChar){
                    swap(row,i,"DOWN"); return true;
                }else if (board[row-1][i]==checkChar){
                    swap(row,i,"UP"); return true;
                }
            }
        }

        // O O X
        for (int i=1; i<board[row].length-2; i++){
            //왼쪽
            if (board[row][i]==board[row][i+1]){
                //왼쪽 위
                if (board[row][i]==board[row-1][i-1]){
                    swap(row,i-1,"UP"); return true;
                //왼쪽 아래
                }else if (board[row][i]==board[row+1][i-1]){
                    swap(row, i-1,"DOWN"); return true;
                //오른쪽 위
                }else if (board[row][i]==board[row-1][i+2]){
                    swap(row,i+2,"UP"); return true;
                //오른쪽 아래
                }else if (board[row][i]==board[row+1][i+2]){
                    swap(row,i+2,"DOWN"); return true;
                }
            }
        }

        // O O X O
        for (int i=1; i<board[row].length-3; i++){
            if (board[row][i]==board[row][i+1]){
                //왼쪽
                if(board[row][i]==board[row][i+3]){
                    swap(row,i+2,"RIGHT"); return true;
                }
            }
        }

        for (int i=2; i<board[row].length-2; i++){
            if (board[row][i]==board[row][i+1]){
                //왼쪽
                if (board[row][i]==board[row][i-2]){
                    swap(row,i-1,"LEFT"); return true;
                }
            }
        }
        return false;
    }


    public static boolean checkPotentialColumnPang(int column){
        char checkChar='O';
        // O X O
        for (int i=2; i<board.length-2; i++){
            if (board[i-1][column]==board[i+1][column]){
                checkChar=board[i-1][column];
                if (board[i][column+1]==checkChar){
                    swap(i,column,"RIGHT");
                    return true;
                }else if (board[i][column-1]==checkChar){
                    swap(i,column,"LEFT");
                    return true;
                }
            }
        }

        // O O X
        for (int i=1; i<board.length-2; i++){
            //왼쪽
            if (board[i][column]==board[i+1][column]){
                //왼쪽 위
                if (board[i][column]==board[i-1][column-1]){
                    swap(i-1,column,"LEFT"); return true;
                    //왼쪽 아래
                }else if (board[i][column]==board[i-1][column+1]){
                    swap( i-1,column,"RIGHT"); return true;
                    //오른쪽 위
                }else if (board[i][column]==board[i+2][column-1]){
                    swap(i+2,column,"LEFT"); return true;
                    //오른쪽 아래
                }else if (board[i][column]==board[i+2][column+1]){
                    swap(i+2,column,"RIGHT"); return true;
                }
            }
        }

        // O O X O
        for (int i=1; i<board.length-3; i++){
            if (board[i][column]==board[i+1][column]){
                //왼쪽
                if(board[i][column]==board[i+3][column]){
                    swap(i+2,column,"DOWN"); return true;
                }
            }
        }

        for (int i=2; i<board.length-2; i++){
            if (board[i][column]==board[i+1][column]){
                //왼쪽
                if (board[i][column]==board[i-2][column]){
                    swap(i-1,column,"UP"); return true;
                }
            }
        }
        return false;
    }


}
