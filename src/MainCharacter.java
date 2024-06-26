

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class MainCharacter {
    GamePanel gp;
    Movement move;
    final int origTileSize = 16;
    final int scale = 4;
    final int tileSize = scale * origTileSize; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int tick = 0; //for the sprite specific movement file
    int playerX = 64;
    int playerY = 64;
    int playerSpeed = 4; //movement related
    public Rectangle solidArea;
    boolean collide = false;




    public BufferedImage up1, up2, right1, right2, left1, left2, down1, down2;
    public String direction = " "; // (u,d,r,l)

    public MainCharacter(GamePanel gp, Movement move) {
        this.gp = gp;
        this.move = move;
        solidArea = new Rectangle(16,16,tileSize/2,tileSize/2);
        getSprite(); //initializes the Sprites

    }


    public void update() {
        if(move.upPressed == true || move.downPressed == true || move.leftPressed == true || move.rightPressed == true) {
            if (move.upPressed == true) {
                direction = "u";
            } else if (move.downPressed == true) {
                direction = "d";

            } else if (move.leftPressed == true) {
                direction = "l";

            } else if (move.rightPressed == true) {
                direction = "r";

            }
            collide = false;

            gp.check.tileChecker(this);

            gp.event.slimeInter(gp.manager.tile[gp.check.tile1], gp.manager.tile[gp.check.tile2]);
            gp.event.wayPoint01Inter(gp.manager.tile[gp.check.tile1], gp.manager.tile[gp.check.tile2]);
            gp.event.ghostInter(gp.manager.tile[gp.check.tile1], gp.manager.tile[gp.check.tile2]);
            gp.event.skeleInter(gp.manager.tile[gp.check.tile1], gp.manager.tile[gp.check.tile2]);
            gp.event.wayPoint02Inter(gp.manager.tile[gp.check.tile1], gp.manager.tile[gp.check.tile2]);
            gp.event.finalBossInter(gp.manager.tile[gp.check.tile1], gp.manager.tile[gp.check.tile2]);


            if (collide == false) {
                switch (direction) {
                    case "u":
                        playerY -= playerSpeed;
                        break;
                    case "d":
                        playerY += playerSpeed;
                        break;
                    case "r":
                        playerX += playerSpeed;
                        break;
                    case "l":
                        playerX -= playerSpeed;
                        break;
                }
            }
        }




    }

    public void draw(Graphics g2) {
        //g2.setColor(Color.GREEN);
        // g2.fillRect(playerX,playerY,tileSize,tileSize);
        //g2.dispose();

        BufferedImage image = null;
        int timer = 0;
        double drawInter = 1000000000.0/200000;

        long lastTime = System.nanoTime();
        double timeCheck = 0;
        long currentTime;
        if (tick == 0) {

            image = switch (direction) { //chooses sprite based of the current direction () gets changes in update()


                case "u" -> up1;
                case "d" -> down1;
                case "l" -> left1;
                case "r" -> right1;
                default -> null;
            };



            currentTime = System.nanoTime();
            timeCheck += (currentTime - lastTime)/ drawInter;
            lastTime = currentTime;

            if(timeCheck > 1){
                timeCheck--;
                tick = 1;


            }



        } else {

            image = switch (direction) { //chooses sprite based of the current direction () gets changes in update()


                case "u" -> up2;
                case "d" -> down2;
                case "l" -> left2;
                case "r" -> right2;
                default -> null;
            };

            currentTime = System.nanoTime();
            timeCheck += (currentTime - lastTime)/ drawInter;
            lastTime = currentTime;

            if(timeCheck > 1){
                timeCheck--;
                tick = 0;


            }



        }

        g2.drawImage(image, playerX, playerY, 64, 64, null); //draws the sprite
    }



    public void getSprite() {
        //initializes the Sprites
        try {
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/up1.png")));      // switch up and down (small miscalculations when creating the Sprite;)
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/up2.png")));
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/down1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/src/PlayerImage/imagesPlayer/down2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/right2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/PlayerImage/imagesPlayer/left2.png")));

        } catch (IOException e) {
            e.printStackTrace(); //catches it if there's an error
        }
    }
}



