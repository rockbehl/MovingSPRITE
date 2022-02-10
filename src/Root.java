public class Root {

    static String grid = "◻️";
    static String X = "🔴";

    static Board worldBoard = new Board(X,grid);

    public static void main(String[] args) {

        worldBoard.generateBoard();
        worldBoard.display();

    }

}
