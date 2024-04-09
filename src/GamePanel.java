

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
    public BufferedImage battleOn4Phase1, battleOn4Phase2, battleOn1, playerAttack, slimeAttack, playerAtkGhost, ghostAtk,battleOn2, slimePlayerHeal, battleOn3,playerAtkSkele,skeleAtk,playerHealSkele, ghostHeal;
    public BufferedImage phase1PlayerAtk, phase2PlayerAtk, phase1Atk, phase2Atk, phase1Regen, phase2Regen, phase1Heal,phase2Heal;
    public BufferedImage phase1Blood, phase2Blood, finish;
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
            playerAttack = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerAttack.png")));
            slimeAttack =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/slimeAttack.png")));
            ghostHeal =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/ghostHeal.png")));
            battleOn2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/battleOneGhost.png")));
            playerAtkGhost = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/playerAtkGhost.png")));
            ghostAtk =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/ghostAtk.png")));
            slimePlayerHeal =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/healAnimationSlime.png")));
            battleOn3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/battleOnSkele.png")));
            playerAtkSkele = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/playerAtkSkele.png")));
            skeleAtk =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/skeleAtk.png")));
            playerHealSkele =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/skeleHeal.png")));
            battleOn4Phase1 =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/battleOn4Phase1.png")));
            battleOn4Phase2 =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/battleOn4Phase2.png")));
            phase1PlayerAtk =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase1PlayerAtk.png")));
            phase2PlayerAtk =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase2PlayerAtk.png")));
            phase1Atk =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase1Atk.png")));
            phase2Atk =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase2Atk.png")));
            phase1Regen =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase1Regen.png")));
            phase2Regen =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase2Regen.png")));
            phase1Heal =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase1Heal.png")));
            phase2Heal =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase2Heal.png")));
            phase1Blood =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase1Blood.png")));
            phase2Blood =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/phase2Blood.png")));
            finish =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/finish.png")));
        } catch (Exception e){

        }







    }




    public void paintComponent(Graphics g){


        super.paintComponent(g); //parent class is gamePlanner
        this.g = g;
         g2 = (Graphics2D) g; //extension of graphic (has special functions)
        if(event.finish){
            g2.drawImage(finish, 0,0,1024,768,null);
        }

        else if(event.skelePlayerHeal){
            g2.drawImage(playerHealSkele, 0,0,1024,768,null);
        }else if(event.phase2Heal){
            g2.drawImage(phase2Heal, 0,0,1024,768,null);
        }
        else if(event.phase1Heal){
            g2.drawImage(phase1Heal, 0,0,1024,768,null);
        } else if(event.phase2Regen){
            g2.drawImage(phase2Regen, 0,0,1024,768,null);
        }
        else if(event.phase1Regen){
            g2.drawImage(phase1Regen, 0,0,1024,768,null);
        }
        else if(event.phase2Atk){
            g2.drawImage(phase2Atk, 0,0,1024,768,null);
        }
        else if(event.phase1Atk){
            g2.drawImage(phase1Atk, 0,0,1024,768,null);
        }
        else if(event.phase2PlayerAtk){
            g2.drawImage(phase2PlayerAtk, 0,0,1024,768,null);
        }
        else if(event.phase1PlayerAtk){
            g2.drawImage(phase1PlayerAtk, 0,0,1024,768,null);
        }

        else if(event.battleOn4Phase2){
            g2.drawImage(battleOn4Phase2, 0,0,1024,768,null);
        }
        else if(event.battleOn4Phase1){
            g2.drawImage(battleOn4Phase1, 0,0,1024,768,null);
        }
        else if(event.skeleAtk){
            g2.drawImage(skeleAtk, 0,0,1024,768,null);
        }

        else if(event.playerAtkSkele){
            g2.drawImage(playerAtkSkele, 0,0,1024,768,null);
        }


        else if(event.battleOn3){
            g2.drawImage(battleOn3, 0,0,1024,768,null);
        }

        else if(event.ghostAtk){
            g2.drawImage(ghostAtk, 0,0,1024,768,null);
        }
        else if(event.slimePlayerHeal){
            g2.drawImage(slimePlayerHeal, 0,0,1024,768,null);
        }
        else if(event.playerAtkGhost){
            g2.drawImage(playerAtkGhost, 0,0,1024,768,null);
        }
        else if(event.battleOn2){
            g2.drawImage(battleOn2, 0,0,1024,768,null);
        }
        else if(event.slimeAtk){
            g2.drawImage(slimeAttack, 0,0,1024,768,null);
        }else if(event.playerAtk) {
            g2.drawImage(playerAttack, 0,0,1024,768,null);
        }
        else if(event.battleOn) {
            g2.drawImage(battleOn1, 0,0,1024,768,null);
        }
        else if(event.currentMap.equals("1")) {
            manager.draw(g2);

        } else if(event.currentMap.equals("2")){
            manager.loadNewMap("map2.txt");
            manager.draw(g2);
        } else {
            manager.loadNewMap("map3.txt");
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

