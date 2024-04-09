import java.util.Scanner;

public class Events {
    Player player;
    Slime slime = new Slime(this);
    Skeleton skele = new Skeleton(this);
    Wraith wraith = new Wraith(this);

    public boolean battleOn = false;

    public boolean slimeAtk = false;
    public boolean playerAtk = false;

    public boolean battleOn2 = false;

    public boolean ghostAtk = false;
    public boolean playerAtkGhost = false;
    public boolean slimePlayerHeal = false;
    public boolean ghostPlayerHeal = false;
    public boolean skelePlayerHeal = false;

    public boolean skeleAtk = false;
    public boolean playerAtkSkele = false;

    public boolean battleOn3 = false;
    public boolean battleOn4Phase1 = false;
    public boolean battleOn4Phase2 = false;
    public boolean phase1PlayerAtk = false;
    public boolean phase2PlayerAtk = false;

    public boolean phase1Atk = false;
    public boolean phase2Atk = false;

    public boolean phase1Regen = false;
    public boolean phase2Regen = false;

    public boolean phase1Heal = false;
    public boolean phase2Heal = false;

    public boolean phase1Blood = false;
    public boolean phase2Blood = false;
    public boolean finish = false;

    Boss bigMan = new Boss(this);



    public Scanner SCAN = new Scanner(System.in);
    public GamePanel gp;

    public String currentMap = "1";


    public Events(GamePanel gp) {
        this.gp = gp;
        player = new Player(gp.move, this);
    }

    public void slimeInter(Tile tile, Tile til) {
        if (tile == gp.manager.tile[5] || til == gp.manager.tile[5]) {
            player.encounter(slime);
            if (player.getHealth() > 0) {

                System.out.println(gp.check.dir);

                switch (gp.joe.direction) {
                    case "u":

                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                        break;
                    case "d":
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                        break;
                    case "l":
                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                        break;
                    case "r":
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                        break;
                }

            } else {
                finish = true;
            }

        }
    }

    public void skeleInter(Tile tile, Tile til) {
        if (tile == gp.manager.tile[9] || til == gp.manager.tile[9]) {
            player.encounter(skele);
            if (player.getHealth() > 0) {

                System.out.println(gp.check.dir);

                switch (gp.joe.direction) {
                    case "u":

                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                        break;
                    case "d":
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                        break;
                    case "l":
                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                        break;
                    case "r":
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                        break;
                }

            }else {
                finish = true;
            }

        }
    }

    public void ghostInter(Tile tile, Tile til) {
        if (tile == gp.manager.tile[8] || til == gp.manager.tile[8]) {
            player.encounter(wraith);
            if (player.getHealth() > 0) {



                switch (gp.joe.direction) {
                    case "u":

                        gp.manager.mapTile[gp.check.left][gp.check.top] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.top] = 0;
                        break;
                    case "d":
                        gp.manager.mapTile[gp.check.left][gp.check.bot] = 0;
                        gp.manager.mapTile[gp.check.right][gp.check.bot] = 0;
                        break;
                    case "r":
                        gp.manager.mapTile[gp.check.top][gp.check.left] = 0;
                        gp.manager.mapTile[gp.check.bot][gp.check.left] = 0;
                        break;
                    case "l":
                        gp.manager.mapTile[gp.check.top][gp.check.right] = 0;
                        gp.manager.mapTile[gp.check.bot][gp.check.right] = 0;
                        break;
                }

            }else {
                finish = true;
            }

        }
    }

    public void wayPoint01Inter(Tile tile, Tile til) {
        if (tile == gp.manager.tile[6] || til == gp.manager.tile[6]) {

            currentMap = "2";
        }

    }

    public void wayPoint02Inter(Tile tile, Tile til) {
        if (tile == gp.manager.tile[7] || til == gp.manager.tile[7]) {

            currentMap = "3";
        }

    }

    public void finalBossInter(Tile tile, Tile til) {
        if (tile == gp.manager.tile[15] || til == gp.manager.tile[15]) {
            player.encounter(bigMan);

            finish = true;

        }
    }


    }

