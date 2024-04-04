public class CollisionSys {
    private GamePanel gp;
    public int tile1,tile2;

    public int left,right,top,bot;public boolean til1 = false, til2 = false;

    public String dir = "";

    public int x[][];


    public CollisionSys(GamePanel gp){
        this.gp = gp;
    }


    public void tileChecker(MainCharacter character){
        dir = "";


        til1 = false;
        til2 = false;
        int leftWorld = (character.playerX + character.solidArea.x);
        int rightWorld = (character.playerX + character.solidArea.x + character.solidArea.width);
        int topWorld = (character.playerY + character.solidArea.y);
        int botWorld = (character.playerY + character.solidArea.y + character.solidArea.height);


         left = leftWorld/ character.tileSize;
         right = rightWorld/character.tileSize;
         top = topWorld/character.tileSize;
         bot = botWorld/character.tileSize;


        switch (character.direction) { //chooses sprite based of the current direction () gets changes in update()
            case "u" -> {
                // top = (topWorld - character.playerSpeed)/character.tileSize;
                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[right][top];









                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "u";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "u";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "d" -> {
                tile1 = gp.manager.mapTile[left][bot];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "d";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "d";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "l" -> {


                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[left][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "l";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "l";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "r" -> {
                tile1 = gp.manager.mapTile[right][top];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "r";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "r";
                    til2 = true;
                    character.collide = true;
                }

                break;
            }
            default -> {
            }
        };




    }
}

