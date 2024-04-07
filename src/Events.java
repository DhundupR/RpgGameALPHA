import java.util.Scanner;

public class Events {
    Player player;
    Slime slime = new Slime();


    public Scanner SCAN = new Scanner(System.in);
    public GamePanel gp;

    public String currentMap = "1";


    public Events(GamePanel gp){
        this.gp = gp;
        player = new Player(gp.move);
    }

    public void slimeInter(Tile tile){
        if(tile == gp.manager.tile[1] || tile == gp.manager.tile[3]){
            System.out.println("nice");
            player.encounter(slime);


            /*if(x.equals("o")){
                if(gp.check.til1 == true){
                    if(gp.check.dir.equals("u")){
                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                        currentMap = "2";
                    }
                }

                if(gp.check.til2 == true){
                    if(gp.check.dir.equals("u")){
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                    }
                }

                if(gp.check.til1 == true){
                    if(gp.check.dir.equals("d")){
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                    }
                }

                if(gp.check.til2 == true){
                    if(gp.check.dir.equals("d")){
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                    }
                }

                if(gp.check.til1 == true){
                    if(gp.check.dir.equals("r")){
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                    }
                }

                if(gp.check.til2 == true){
                    if(gp.check.dir.equals("r")){
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                    }
                }

                if(gp.check.til1 == true){
                    if(gp.check.dir.equals("l")){
                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                    }
                }

                if(gp.check.til2 == true){
                    if(gp.check.dir.equals("l")){
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                    }
                }





            }
        */

        }
    }

    public void skeletonInter(Tile tile){
        if(tile == gp.manager.tile[1]){
            System.out.println("WOOO");
        }
    }
}
