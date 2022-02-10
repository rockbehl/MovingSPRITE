import java.util.Objects;

public class Player {

    private int PosX;
    private int PosY;
    private int spawnPosX;
    private int spawnPosY;
    private String PlayerFace;

    Player(){
        PlayerFace = "@";
    }
    Player(String playerFace){
        PlayerFace = playerFace;
    }

    public String getFace() {
        return PlayerFace;
    }

    public int getCurrentPosX(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Objects.equals(arr[i][j], getFace())){
                    PosX = j;
                    break;
                }
            }
        }

        return PosX;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public int getCurrentPosY(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Objects.equals(arr[i][j], getFace())){
                    PosY = i;
                    break;
                }
            }
        }

        return PosY;
    }

    public int getPosY() {
        return PosY;
    }
}
