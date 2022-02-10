import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Board {

    Random rand = new Random();
    Player plyr = new Player("😁");

    private String wall;
    private String playSpace;
    private String[][] Grid = new String[8][24];
    private boolean win = false;
    private int state = 0;

    Board(String wall, String playSpace){

        this.playSpace = playSpace;
        this.wall = wall;

    }


    //Main Funcs
    public void generateBoard(){

        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[0].length; j++) {
                Grid[i][j] = playSpace;
            }
        }

        //edge spawning

        for (int i = 0; i < Grid[0].length; i++) {
            Grid[0][i] = wall;
        }
        for (int i = 0; i < Grid.length; i++) {
            Grid[i][0] = wall;
        }
        for (int i = 0; i < Grid[0].length; i++) {
            Grid[7][i] = wall;
        }
        for (int i = 0; i < Grid.length; i++) {
            Grid[i][23] = wall;
        }

        //mid wall spawning

        for (int i = 0; i < 15; i++) {
            setWallsInSpace();
        }

        //spawn object

        setObjInSpace();

        //spawn player

        setPlayerInSpace();

    }
    public void updateBoard(){
        Scanner sc = new Scanner(System.in);

        //allow user input
        System.out.println("Use W,A,S,D to move.");
        System.out.print("Input: ");
        String input = sc.nextLine();
        input = input.toLowerCase();


        //move player
        Grid[plyr.getPosY()][plyr.getPosX()] = playSpace;

        switch (input){
            case "w" -> plyr.setPosY(plyr.getCurrentPosY(getGrid())-1);
            case "a" -> plyr.setPosX(plyr.getCurrentPosX(getGrid())-1);
            case "s" -> plyr.setPosY(plyr.getCurrentPosY(getGrid())+1);
            case "d" -> plyr.setPosX(plyr.getCurrentPosX(getGrid())+1);
        }

        //check for win/loss

        if (isSpaceOpen(plyr.getPosX(), plyr.getPosY())) {
            Grid[plyr.getPosY()][plyr.getPosX()] = plyr.getFace();
            state = 0;
        } else if (Objects.equals(Grid[plyr.getPosY()][plyr.getPosX()], "🕋")){
            win = true;
            System.out.println("YOU WIN!");
            state = 1;
        }   else {
            win = true;
            System.out.println("YOU LOSE!");
            state = 2;
        }

        //if win, update board/change level
        //if lose, end game
    }


    //Unique Funcs
    public void setWallsInSpace(){
        boolean set = false;

        while (!set) {

            int x = rand.nextInt(23);
            int y = rand.nextInt(7);
            int random = rand.nextInt(4);

            if (isSpaceOpen(x, y)) {
                Grid[y][x] = wall;
                if (random == 1){
                    Grid[y][x+1] = wall;
                } else if (random == 3){
                    Grid[y-1][x] = wall;
                }
                set = true;
            }
        }
    }
    public void setObjInSpace(){
        boolean set = false;

        while (!set) {

            int x = rand.nextInt(23);
            int y = rand.nextInt(7);

            if (isSpaceOpen(x, y)) {
                Grid[y][x] = "🕋";
                set = true;
            }
        }
    }
    public void setPlayerInSpace(){
        boolean set = false;

        while (!set) {

            int x = rand.nextInt(23);
            int y = rand.nextInt(7);

            if (isSpaceOpen(x, y)) {
                Grid[y][x] = plyr.getFace();
                set = true;
            }
        }
    }


    //Utility Funcs
    public boolean isSpaceOpen(int x, int y){
        if (Grid[y][x] == playSpace){
            return true;
        } else {
            return false;
        }
    }
    public void display(){
        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[0].length; j++) {
                System.out.print(Grid[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] getGrid() {
        return Grid;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getState() {
        return state;
    }
}
