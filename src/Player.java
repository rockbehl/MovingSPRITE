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
}
