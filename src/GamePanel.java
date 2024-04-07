

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class GamePanel extends JPanel implements Runnable {
    final int origTileSize = 16;
    final int scale = 4;
    final int tileSize = scale*origTileSize; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    public BufferedImage battleOn1;


    public CollisionSys check;











    public Movement move = new Movement();
    MainCharacter joe = new MainCharacter(this, move);

    public Events event = new Events(this);


    int playerX = 100; int playerY = 100; int playerSpeed= 10; //movement related
    public Graphics2D g2;
    public Graphics g;


    double fps = 60;
    Thread gameThread; //Keeps the image running and has uses later like reset screen and other stuff.


    public TileManager manager = new TileManager(this);



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
        check = new CollisionSys(this);
        try {
            battleOn1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/BackgroundStartBase1.png")));
        } catch (Exception e){

        }







    }




    public void paintComponent(Graphics g){


        super.paintComponent(g); //parent class is gamePlanner
        this.g = g;
         g2 = (Graphics2D) g; //extension of graphic (has special functions)


        if(event.battleOn) {
            g2.drawImage(battleOn1, 0,0,1024,768,null);
        }
        else if(event.currentMap.equals("1")) {
            manager.draw(g2);
        } else {
            manager.loadNewMap("map2.txt");
            manager.draw(g2);
        }



        joe.draw(g2);




    }


    public void startGame(){ //innate the thread
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void update(){ //dont know why its opposite


    }




    @Override
    public void run() {
        double drawInter = 1000000000.0/fps;




        long lastTime = System.nanoTime();
        double timeCheck = 0;
        long currentTime;


        while(gameThread != null){ //keeps thing going until something occurs or breaks
            currentTime = System.nanoTime();
            timeCheck += (currentTime - lastTime)/ drawInter;
            lastTime = currentTime;


            if(timeCheck > 1){


                joe.update();


                repaint();
                timeCheck--; //resets back to zero!
            }


        }


    }
}

