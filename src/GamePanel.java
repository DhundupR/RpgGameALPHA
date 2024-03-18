
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int origTileSize = 16;
    final int scale = 4;
    final int tileSize = scale*origTileSize; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;



    Movement move = new Movement();
    MainCharacter joe = new MainCharacter(this, move);

    int playerX = 100; int playerY = 100; int playerSpeed= 10; //movement related

    double fps = 60;
    Thread gameThread; //Keeps the image running and has uses later like reset screen and other stuff.

    TileManager manager = new TileManager(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); //parent class is gamePlanner
        Graphics2D g2 = (Graphics2D) g; //extension of graphic (has special functions)
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
