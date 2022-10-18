import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int count=0;
        Board.sleepTimeMil = 0;
        Board.charRange = 6;

        Board.showBoard("Initial");
        Board.fillAllLines();
        Board.showBoard("First Fill");

        Loop1:
        while (true) {

            for (int i = Board.board.length - 2; i >= 1; i--) {
                PotentialPang.checkPotentialRowPang(i);
                Board.showBoard("");
                while (Board.checkRowPang(i)) {
                    Board.fillAllLines();
                    Board.checkRowPang(i - 1);
                    Board.checkRowPang(i);
                    Board.checkRowPang(i + 1);
                }
                Board.showBoard("");

                PotentialPang.checkPotentialColumnPang(i);
                Board.showBoard("");
                while (Board.checkColumnPang(i)) {
                    Board.fillAllLines();
                    Board.checkColumnPang(i - 1);
                    Board.checkColumnPang(i);
                    Board.checkColumnPang(i + 1);
                }
                Board.showBoard("");
            }
            for (int i = Board.board.length - 2; i >= 1; i--) {
                if ((!PotentialPang.checkPotentialColumnPang(i) && !PotentialPang.checkPotentialRowPang(i) && !Board.checkColumnPang(i) && !Board.checkRowPang(i))){
                    count+=1;
                }else{
                    count=0;
                }
                if (count==8) break Loop1;
            }
        }

        System.out.println("Final Score : " + Board.scores);
    }
}