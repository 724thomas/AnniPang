public class Main {
    public static void main(String[] args) {

        Board.showBoard();
        Board.firstFill();
        for (int j=0; j<2; j++){
            for (int i=Board.board.length-1; i>=0;i--){
    //            Board.checkRowPang(i);
                Board.checkColumnPang(i);
                Board.charGoesDown();
                Board.showBoard();
                Board.fillAllLines();
                Board.showBoard();
                Board.checkRowPang(i);
                Board.charGoesDown();
                Board.showBoard();
                Board.fillAllLines();
                Board.showBoard();
            }
        }
        System.out.println(Board.scores);



    }
}