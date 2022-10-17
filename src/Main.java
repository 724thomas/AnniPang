public class Main {
    public static void main(String[] args) {

        Board.showBoard();
        Board.firstFill();
        for (int i=Board.board.length-1; i>=0;i--){
            Board.checkRow(i);
            Board.charGoesDown();
            Board.showBoard();
        }





    }
}