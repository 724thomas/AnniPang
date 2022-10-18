import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Board.sleepTimeMil=0;
        Board.charRange=6;


        Board.showBoard("Initial");
        Board.firstFill();
        Board.showBoard("First Fill");
        Loop1:
        while (true){
            for(int i=0; i<Board.board.length-1; i++){
                PotentialPang.checkPotentialRowPang(i);
                Board.checkFillCheck();
                PotentialPang.checkPotentialColumnPang(i);
                Board.checkFillCheck();
            }
            for (int i=0; i<Board.board.length-1; i++){
                if (!Board.checkColumnPang(i) && !Board.checkRowPang(i)){
                    break Loop1;
                }
            }

        }
    }
}