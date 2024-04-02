public class Events {
    public GamePanel gp;


    public Events(GamePanel gp){
        this.gp = gp;
    }

    public void slimeInter(Tile tile){
        if(tile == gp.manager.tile[1]){
            System.out.println("nice");
        }
    }

    public void skeletonInter(Tile tile){
        if(tile == gp.manager.tile[1]){
            System.out.println("WOOO");
        }
    }
}
