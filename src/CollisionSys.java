public class CollisionSys {
    private GamePanel gp;
    public int tile1,tile2;
    public CollisionSys(GamePanel gp){
        this.gp = gp;
    }


    public void tileChecker(MainCharacter character){




        int leftWorld = (character.playerX + character.solidArea.x);
        int rightWorld = (character.playerX + character.solidArea.x + character.solidArea.width);
        int topWorld = (character.playerY + character.solidArea.y);
        int botWorld = (character.playerY + character.solidArea.y + character.solidArea.height);


        int left = leftWorld/ character.tileSize;
        int right = rightWorld/character.tileSize;
        int top = topWorld/character.tileSize;
        int bot = botWorld/character.tileSize;


        switch (character.direction) { //chooses sprite based of the current direction () gets changes in update()
            case "u" -> {
                // top = (topWorld - character.playerSpeed)/character.tileSize;
                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[right][top];






                if(gp.manager.tile[tile1].collision == true || gp.manager.tile[tile2].collision == true ){


                    character.collide = true;
                }
                break;
            }
            case "d" -> {
                tile1 = gp.manager.mapTile[left][bot];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true || gp.manager.tile[tile2].collision == true ){


                    character.collide = true;
                }
                break;
            }
            case "l" -> {
                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[left][bot];
                if(gp.manager.tile[tile1].collision == true || gp.manager.tile[tile2].collision == true ){


                    character.collide = true;
                }
                break;
            }
            case "r" -> {
                tile1 = gp.manager.mapTile[right][top];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true || gp.manager.tile[tile2].collision == true ){


                    character.collide = true;
                }

                break;
            }
            default -> {
            }
        };




    }
}

