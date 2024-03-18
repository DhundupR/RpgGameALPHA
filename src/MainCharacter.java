import com.sun.tools.javac.Main;

import java.awt.*;

public class MainCharacter  {
    GamePanel gp;
    Movement move;
    final int origTileSize = 16;
    final int scale = 4;
    final int tileSize = scale*origTileSize; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int playerX = 100; int playerY = 100; int playerSpeed= 10; //movement related

    public MainCharacter(GamePanel gp, Movement move){
        this.gp = gp;
        this.move = move;

    }

    public void setDefault(){

    }

    public void update(){
        if(move.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(move.downPressed == true){
            playerY += playerSpeed;
        }
        else if(move.leftPressed == true){
            playerX -= playerSpeed;
        }else if(move.rightPressed == true){
            playerX += playerSpeed;
        }

        if(playerX < 0){
            playerX += playerSpeed;
        }
        if(playerX > screenWidth - tileSize){
            playerX -= playerSpeed;
        }

        if(playerY < 0){
            playerY += playerSpeed;
        }
        if(playerY > screenHeight- tileSize){
            playerY -= playerSpeed;
        }
    }

    public void draw(Graphics g2 ){
        g2.setColor(Color.GREEN);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();

    }

}
