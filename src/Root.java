public class Root {

    static String grid = "◻️";
    static String X = "🔴";

    static Board worldBoard = new Board(X,grid);

    public static void main(String[] args) {

        int turns = 0;
        int score = 0;

        while (turns < 3) {

            System.out.println("======== SCORE: "+score+" ========");
            System.out.println("You have died: "+turns+"/3 times!");
            worldBoard.generateBoard();

            while (!worldBoard.isWin()) {
                worldBoard.display();
                System.out.println(worldBoard.plyr.getCurrentPosX(worldBoard.getGrid()) + ", " + worldBoard.plyr.getCurrentPosY(worldBoard.getGrid()));
                worldBoard.updateBoard();
                if (worldBoard.getState() == 2){
                    turns++;
                }
                if (worldBoard.getState() == 1){
                    score++;
                }
            }

            worldBoard.setWin(false);
            if (turns == 3){
                System.out.println("======== SCORE: "+score+" ========");
                System.out.println("You have died: "+turns+"/3 times!");
            }

        }

    }

}
